package com.sudesh.org.rewards.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SU20026464 on 2/1/2019.
 */
@Entity
@Table(name = "PAYMENT_CARD")
public class PaymentCard {
    public PaymentCard() {
            }

    @Id
    @GeneratedValue
    @Column(name = "PAYMENTCARD_ID")
    private Long paymentCardId ;

    @Column(name = "CUSTOMER_ID")
    private Long customerId ;

    @Column(name = "BANK_ACCOUNT_NUMBER")
    private String bankAccountNumber ;

    @Column(name = "BANK_CARD_PRODUCT")
    private String bankCardProduct ;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankCardProduct() {
        return bankCardProduct;
    }

    public void setBankCardProduct(String bankCardProduct) {  this.bankCardProduct = bankCardProduct; }

     public Long getPaymentCardId() {
        return paymentCardId;
    }

    public void setPaymentCardId(Long paymentCardId) {
        this.paymentCardId = paymentCardId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }





}
