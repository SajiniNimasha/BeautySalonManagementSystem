/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import java.util.ArrayList;
import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.ServiceDetailDTO;

/**
 *
 * @author Vidu
 */
public interface ServiceDetailBO extends SuperBO{
    
    public ArrayList<ServiceDetailDTO>loadAllServices() throws Exception;
}
