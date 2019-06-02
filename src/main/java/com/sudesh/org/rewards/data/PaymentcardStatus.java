package com.sudesh.org.rewards.data;

/**
 * Created by SU20026464 on 2/18/2019.
 */


public class PaymentcardStatus {



    private String bankAccountNumber ;
    private String status;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentcardStatus)) return false;

        PaymentcardStatus that = (PaymentcardStatus) o;

        if (!getBankAccountNumber().equals(that.getBankAccountNumber())) return false;
        return getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        int result = getBankAccountNumber().hashCode();
        result = 31 * result + getStatus().hashCode();
        return result;
    }
}
