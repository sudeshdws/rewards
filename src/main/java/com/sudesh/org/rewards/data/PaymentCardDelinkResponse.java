package com.sudesh.org.rewards.data;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by SU20026464 on 2/18/2019.
 */

@Data
public class PaymentCardDelinkResponse {
    private String bankCustomerNumber ;
    private String businessPartnerName;
    private int delinkCount =0 ;
    ArrayList<PaymentcardStatus> paymentcardStatuses = new ArrayList<>();

}
