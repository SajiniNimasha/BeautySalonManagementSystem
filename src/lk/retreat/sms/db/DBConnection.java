/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    
    private DBConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","Sajini.nimasha1996");
    }
    
    public static DBConnection getInstance() throws Exception{
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
