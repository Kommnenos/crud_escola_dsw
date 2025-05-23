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
        String sql = "SELECT * from Aluno a, Classe c WHERE a.classe_id = c.id";

        try{
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return listaAlunos;
    }



}
