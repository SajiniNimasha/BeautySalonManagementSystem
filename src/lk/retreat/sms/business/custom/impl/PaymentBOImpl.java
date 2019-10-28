/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.business.custom.impl;

import java.util.ArrayList;
import lk.retreat.sms.business.custom.PaymentBO;
import lk.retreat.sms.dao.DAOFactory;
import lk.retreat.sms.dao.custom.PaymentDAO;
import lk.retreat.sms.dto.PaymentDTO;
import lk.retreat.sms.entity.Payment;

/**
 *
 * @author Vidu
 */
public class PaymentBOImpl implements PaymentBO{

    private PaymentDAO paymentDAO;

    public PaymentBOImpl() {
        
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    }
    
    
    
    @Override
    public ArrayList<PaymentDTO> loadAllPayments() throws Exception {
        
        ArrayList<Payment> list=paymentDAO.getAll();
        ArrayList<PaymentDTO> payList=new ArrayList<>();
        
        for (Payment payment : list) {
            payList.add(new PaymentDTO(payment.getPaymentId(),payment.getPrice()));
        }
        
        return payList;
    }
    
}
