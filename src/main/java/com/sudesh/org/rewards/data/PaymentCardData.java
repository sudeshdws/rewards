package com.sudesh.org.rewards.data;

/**
 * Created by SU20026464 on 2/2/2019.
 */
public class PaymentCardData {
    private String bankAccountNumber ;
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

    public void setBankCardProduct(String bankCardProduct) {
        this.bankCardProduct = bankCardProduct;
    }
}
