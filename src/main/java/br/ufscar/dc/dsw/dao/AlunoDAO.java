package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.domain.Classe;
import br.ufscar.dc.dsw.types.Periodo;

public class AlunoDAO extends GenericDAO{

    public void insert(Aluno aluno){

        String sql = "INSERT INTO Aluno (nome, sobrenome, pcd, ano_nasc, classe_id) VALUES (?, ?, ?, ?, ?)";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getSobrenome());
            statement.setBoolean(3, aluno.isPcd());
            statement.setShort(4, aluno.getAno_nasc());
            statement.setInt(5, aluno.getClasse().getId());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> getAll(){

        List<Aluno> listaAlunos = new ArrayList<>();
        String sql = "SELECT a.id, a.nome, a.sobrenome, a.pcd, a.ano_nasc, a.cursando, a.classe_id, " +
                "c.nome as classe_nome, c.sala_num, c.predio, c.periodo, c.em_curso, c.serie, c.ano " +
                "FROM Aluno a, Classe c WHERE a.classe_id = c.id";

        try{
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int aluno_id = resultSet.getInt("id");
                String aluno_nome = resultSet.getString("nome");
                String aluno_sobrenome = resultSet.getString("sobrenome");
                boolean aluno_pcd = resultSet.getBoolean("pcd");
                short aluno_ano_nasc = resultSet.getShort("ano_nasc");
                boolean aluno_cursando = resultSet.getBoolean("cursando");
                int aluno_classe_id = resultSet.getInt("classe_id");
                String classe_nome = resultSet.getString("nome");
                short classe_sala_num = resultSet.getShort("sala_num");
                char classe_predio = resultSet.getString("predio").charAt(0);
                Periodo classe_periodo = Periodo.valueOf(resultSet.getString("periodo"));
                boolean classe_em_curso = resultSet.getBoolean("em_curso");
                byte classe_serie = resultSet.getByte("serie");
                short classe_ano = resultSet.getShort("ano");
                Classe classe = new Classe(aluno_classe_id, classe_nome, classe_sala_num, classe_predio, classe_periodo, classe_em_curso, classe_serie, classe_ano);
                Aluno aluno = new Aluno(aluno_id, aluno_nome, aluno_sobrenome, aluno_pcd, aluno_ano_nasc, classe, aluno_cursando);
                listaAlunos.add(aluno);
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return listaAlunos;
    }

    public void delete(Aluno aluno){
        String sql = "DELETE FROM Aluno WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, aluno.getId());
            statement.execute();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Aluno aluno){

        String sql = "UPDATE Aluno SET nome = ?, sobrenome = ?, pcd = ?, ano_nasc = ?, cursando = ? classe_id = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getSobrenome());
            statement.setBoolean(3, aluno.isPcd());
            statement.setShort(4, aluno.getAno_nasc());
            statement.setBoolean(5, aluno.isCursando());
            statement.setInt(6, aluno.getClasse().getId());
            statement.setInt(7, aluno.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Aluno getById(int id){
        Aluno aluno = null;
        String sql = "SELECT * FROM Aluno a, Classe c WHERE a.id = ? AND a.classe_id = c.id";

        try {

            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                boolean pcd = resultSet.getBoolean("pcd");
                short ano_nasc = resultSet.getShort("ano_nasc");
                boolean cursando = resultSet.getBoolean("cursando");

                int classe_id = resultSet.getInt("classe_id");
                Classe classe = new ClasseDAO().getById(classe_id);

                aluno = new Aluno(id, nome, sobrenome, pcd, ano_nasc, classe, cursando);

                resultSet.close();
                statement.close();
                conn.close();

            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return aluno;
    }



}
