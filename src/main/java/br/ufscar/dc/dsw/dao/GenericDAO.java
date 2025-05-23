package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO{

    public GenericDAO(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException{
        String user = "postgres";
        String password = "12345";
        String url = "jdbc:postgresql://localhost:5432/escola";
        return DriverManager.getConnection(url, user, password);
    }



}
