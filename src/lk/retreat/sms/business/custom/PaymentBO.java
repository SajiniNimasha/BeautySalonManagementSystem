/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom;

import java.util.ArrayList;
import lk.retreat.sms.business.SuperBO;
import lk.retreat.sms.dto.PaymentDTO;

/**
 *
 * @author Vidu
 */
public interface PaymentBO extends SuperBO{
    
    public ArrayList<PaymentDTO>loadAllPayments() throws Exception;
    
}
