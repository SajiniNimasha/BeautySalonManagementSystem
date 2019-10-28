/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.ClientDAO;
import lk.retreat.sms.db.DBConnection;
import lk.retreat.sms.entity.Client;

/**
 *
 * @author User
 */
public class ClientDAOImpl implements ClientDAO{
    
    private Connection connection;

    public ClientDAOImpl() {
        
        try {
            connection=DBConnection.getInstance().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public ArrayList<Client> getAll() throws Exception{
    
            ResultSet rst = CrudUtil.executeQuery("select clientId,clientName from client");
            ArrayList<Client> cusAll = new ArrayList<>();
            while (rst.next()) {
                Client cus = new Client(rst.getString(1), rst.getString(2));
                cusAll.add(cus);
            }
            return cusAll;
     }

    @Override
    public boolean delete(String ID) throws Exception{
    
        
            return CrudUtil.executeUpdate("DELETE FROM client WHERE clientId=?", ID);
     
     
}

    @Override
    public Client getSearchDetail(String text) throws Exception {
        ResultSet rs=CrudUtil.executeQuery("select * from client where clientid=?", text);
        if(rs.next()){
            return new Client(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
        }
        return null;
    }

    @Override
    public boolean save(Client entity) throws Exception {
        System.out.println("client: "+entity);
        
        PreparedStatement stm=connection.prepareStatement("insert into client values(?,?,?,?,?,?)");
        stm.setObject(1, entity.getClientId());
        stm.setObject(2, entity.getClientName());
        stm.setObject(3, entity.getClientAddress());
        stm.setObject(4, entity.getClientTel());
        stm.setObject(5, entity.getClientEmaill());
        stm.setObject(6, entity.getFirstInDate());
        
        return stm.executeUpdate()>0;
        
//        return CrudUtil.executeUpdate("insert into client values(clientId=?,clientName=?,clientAddress=?,clientTel=?,clientEmail=?,firstInDate=?);",entity.getClientId(),entity.getClientName(),entity.getClientAddress(),entity.getClientTel(),entity.getClientEmaill(),entity.getFirstInDate());
    }

    @Override
    public boolean update(Client client) throws Exception {
        String sql="Update Client set  clientName=? , clientAddress=? ,clientTel=?, clientEmail=? where clientId=?";
        return CrudUtil.executeUpdate(sql,client.getClientId(),client.getClientName(),client.getClientAddress(),client.getClientTel(),client.getClientEmaill());
    }
    
}
