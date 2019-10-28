/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.retreat.sms.dao.CrudUtil;
import lk.retreat.sms.dao.custom.ServiceDetailDAO;
import lk.retreat.sms.entity.ServiceDetail;

/**
 *
 * @author Vidu
 */
public class ServiceDetailDAOImpl implements ServiceDetailDAO{

    @Override
    public ArrayList<ServiceDetail> getAll() throws Exception {
        
        ResultSet rst = CrudUtil.executeQuery("select * from servicedetail");
            ArrayList<ServiceDetail> serviceAll = new ArrayList<>();
            while (rst.next()) {
                ServiceDetail service = new ServiceDetail(rst.getString(1), rst.getString(2),rst.getString(3));
                serviceAll.add(service);
            }
            return serviceAll;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(ServiceDetail entity) throws Exception {
        System.out.println("service detail: "+entity);
        return CrudUtil.executeUpdate("insert into servicedetail values(?,?,?);",entity.getServiceDetailId(),entity.getCategory(),entity.getAppId());
    }

    @Override
    public boolean update(ServiceDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
