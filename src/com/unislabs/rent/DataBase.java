package com.unislabs.rent;

import java.io.IOException;
import java.sql.*;

public class DataBase {
    private DataBase dataBase = null;
    private  Connection con;

    private DataBase() throws SQLException, IOException{
        super();
        String url = Prop.getProp(Prop.JDBC_URL);
        String user = Prop.getProp(Prop.JDBC_USER);
        String password = Prop.getProp(Prop.JDBC_PASSWORD);
        con = DriverManager.getConnection(url,user,password);
    }

    public DataBase getInstance() throws SQLException,IOException{
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return  dataBase;
    }

    public Floor getFloorById(int id) throws SQLException{
        PreparedStatement pst = con.prepareStatement("Select * FROM test WHERE id=?");
        ResultSet rs = new executeQuery();
        Floor floor = null;
        if (rs.next){
            floor = new Floor(rs.getString("name"), true, getTCById(rs.getInt("tc_id")));
        }
        rs.close;
    }

    private class executeQuery implements ResultSet {}
}
