package com.sudesh.org.rewards.data;

import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * Created by SU20026464 on 2/2/2019.
 */
public class CustomerRequest implements Serializable{
    @NonNull
    private String bankCustomerNumber ;
    @NonNull
    private String bussinessPartner ;//Bank name
    private String address ;
    private String postalCode;
    private String customerToken ;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

}

