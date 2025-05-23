package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Classe;
import br.ufscar.dc.dsw.types.Periodo;

public class ClasseDAO extends GenericDAO{

    public List<Classe> getAll(){

        List<Classe> listaClasses = new ArrayList<>();
        String sql = "SELECT * FROM Classe";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                short sala_num = resultSet.getShort("sala_num");
                char predio = resultSet.getString("predio").charAt(0);
                Periodo periodo = Periodo.valueOf(resultSet.getString("periodo"));
                boolean em_curso = resultSet.getBoolean("em_curso");
                byte serie = resultSet.getByte("serie");
                short ano = resultSet.getShort("ano");
                Classe classe = new Classe(id, sala_num, predio, periodo, em_curso, serie, ano);
                listaClasses.add(classe);
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClasses;
    }

    public Classe getById(int id){

        Classe classe = null;
        String sql = "SELECT * FROM Classe WHERE id = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                short sala_num = resultSet.getShort("sala_num");
                char predio = resultSet.getString("predio").charAt(0);
                Periodo periodo = Periodo.valueOf(resultSet.getString("periodo"));
                boolean em_curso = resultSet.getBoolean("em_curso");
                byte serie = resultSet.getByte("serie");
                short ano = resultSet.getShort("ano");
                classe = new Classe(id, sala_num, predio, periodo, em_curso, serie, ano);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classe;
    }

}
