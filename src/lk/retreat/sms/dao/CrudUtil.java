/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.retreat.sms.db.DBConnection;

/**
 *
 * @author User
 */
public class CrudUtil {
     public static PreparedStatement getPreaparedStatement(String sql, Object... obj) throws SQLException, ClassNotFoundException, IOException, Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < obj.length; i++) {
            
            pstm.setObject(i + 1, obj[i]);
        }
        return pstm;
    }

    public static ResultSet executeQuery(String sql, Object... obj) throws SQLException, ClassNotFoundException, IOException, Exception{
        return getPreaparedStatement(sql, obj).executeQuery();
    }

    public static boolean executeUpdate(String sql, Object... obj) throws SQLException, ClassNotFoundException, IOException, Exception {
        
        return getPreaparedStatement(sql, obj).executeUpdate()>0;

    }
    
    
}
