package com.sudesh.org.rewards.data;

import com.sudesh.org.rewards.model.PaymentCard;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

/**
 * Created by SU20026464 on 2/2/2019.
 */
public class PaymentCardRequest {

    private String bankCustomerNumber ;
    private String bussinessPartner ;//Bank name
    private Set<PaymentCardData> paymentCardData;

    public Set<PaymentCardData> getPaymentCardData() {
        return paymentCardData;
    }

    public void setPaymentCardData(Set<PaymentCardData> paymentCardData) {
        this.paymentCardData = paymentCardData;
    }

    public String getBankCustomerNumber() {
        return bankCustomerNumber;
    }

    public void setBankCustomerNumber(String bankCustomerNumber) {
        this.bankCustomerNumber = bankCustomerNumber;
    }

    public String getBussinessPartner() {
        return bussinessPartner;
    }

    public void setBussinessPartner(String bussinessPartner) {
        this.bussinessPartner = bussinessPartner;
    }


}
