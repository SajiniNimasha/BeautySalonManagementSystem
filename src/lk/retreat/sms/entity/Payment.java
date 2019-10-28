/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.retreat.sms.entity;

/**
 *
 * @author Vidu
 */
public class Payment {
    
    private String paymentId;
    private double price;

    public Payment() {
    }

    public Payment(String paymentId, double price) {
        this.paymentId = paymentId;
        this.price = price;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", price=" + price + '}';
    }
    
    
}
