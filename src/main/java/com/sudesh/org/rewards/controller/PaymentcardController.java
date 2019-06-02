package com.sudesh.org.rewards.controller;

import com.sudesh.org.rewards.data.PaymentCardData;
import com.sudesh.org.rewards.data.PaymentCardDelinkResponse;
import com.sudesh.org.rewards.data.PaymentCardRequest;
import com.sudesh.org.rewards.service.PaymentCardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

/**
 * Created by SU20026464 on 2/2/2019.
 */
@RestController
@Api
@RequestMapping("/paymentcard")
public class PaymentcardController {

    @Autowired
    public PaymentCardService paymentCardService;


    @PostMapping("/add")
        public void savePaymentCard(@RequestBody PaymentCardRequest paymentCardRequest) throws Exception {
        paymentCardService.savePaymentCard(paymentCardRequest);
        }


     @GetMapping("paymentcard/{bankCutomerNumber}")
     public ResponseEntity<Set<PaymentCardData>> getPaymentcardDetail(@PathVariable("bankCutomerNumber") String bankCutomerNumber) {
         Set<PaymentCardData> paymentCardData = paymentCardService.getPaymentCardDetail(bankCutomerNumber);
         return ResponseEntity.ok(paymentCardData);
     }


    @DeleteMapping("/")
    public ResponseEntity<PaymentCardDelinkResponse> dellinkPaymentCards(@Valid @RequestBody PaymentCardRequest paymentCardRequest){
        PaymentCardDelinkResponse paymentCardDelinkResponse = paymentCardService.delinkPaymentCard(paymentCardRequest);
        return  ResponseEntity.ok(paymentCardDelinkResponse);
    }







}
