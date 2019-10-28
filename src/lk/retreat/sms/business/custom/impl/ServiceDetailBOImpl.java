/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import lk.retreat.sms.business.custom.ServiceDetailBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.ServiceDetailDAO;
import lk.retreat.sms.dto.ServiceDetailDTO;
import lk.retreat.sms.entity.ServiceDetail;

/**
 *
 * @author Vidu
 */
public class ServiceDetailBOImpl implements ServiceDetailBO{

    private ServiceDetailDAO serviceDetailDAO;

    public ServiceDetailBOImpl() {
        
        serviceDetailDAO=(ServiceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE_DETAIL);
    }
    
    
    
    @Override
    public ArrayList<ServiceDetailDTO> loadAllServices() throws Exception {
        
        ArrayList<ServiceDetail> services=serviceDetailDAO.getAll();
        ArrayList<ServiceDetailDTO> list=new ArrayList<>();
        
        for (ServiceDetail service : services) {
            list.add(new ServiceDetailDTO(service.getServiceDetailId(),service.getCategory(),service.getAppId()));
        }
        return list;
    }
    
}
