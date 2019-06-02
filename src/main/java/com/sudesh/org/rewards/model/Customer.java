package com.sudesh.org.rewards.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SU20026464 on 2/1/2019.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{

    @Id
    @GeneratedValue
    @Column(name ="CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_TOKEN")
    private String customerToken ;

    @NonNull
    @Column(name = "BANK_CUSTOMER_NUMBER")
    private String bankCustomerNumber ;

    @NonNull
    @Column(name = "BUSSINESS_PARTNER")
    private String bussinessPartner ;//Bank name
    @Column(name = "ADDRESS")
    private String address ;
    @Column(name = "POSTALCODE")
    private String postalCode;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CUSTOMER_ID")
    private Set<PaymentCard> paymentCards;

    public Customer(){

    }

    public Customer paymentcards(Set<PaymentCard> paymentCards) {
       if(this.paymentCards == null){
           this.paymentCards = new HashSet<>(paymentCards);
       }else{
           this.paymentCards.clear();
           this.paymentCards.addAll(paymentCards);
       }
       return this;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public Set<PaymentCard> getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(Set<PaymentCard> paymentCards) {
        this.paymentCards = paymentCards;
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




}
