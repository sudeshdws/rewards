package com.sudesh.org.rewards.service;

import com.sudesh.org.rewards.data.PaymentCardData;
import com.sudesh.org.rewards.data.PaymentCardDelinkResponse;
import com.sudesh.org.rewards.data.PaymentCardRequest;
import com.sudesh.org.rewards.data.PaymentcardStatus;
import com.sudesh.org.rewards.model.Customer;
import com.sudesh.org.rewards.model.PaymentCard;
import com.sudesh.org.rewards.repository.CustomerRepository;
import com.sudesh.org.rewards.repository.PaymentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by SU20026464 on 2/2/2019.
 */
@Service
public class PaymentCardService {

    @Autowired
    public PaymentCardRepository paymentCardRepository;

    @Autowired
    public CustomerRepository customerRepository ;


    @Transactional
    public void savePaymentCard(PaymentCardRequest paymentCardRequest) throws Exception {
        Set<PaymentCard> cusotmerPaymentCard = new HashSet<>();
        Set<PaymentCard> cardsToAdd = new HashSet<>();
      Customer  cusotomer = customerRepository.findByBankCustomerNumber(paymentCardRequest.getBankCustomerNumber());
        System.out.println("====================================== Customer ID :"+ cusotomer.getCustomerId());

        //Jdk 8
        System.out.println("payment card is exists "+paymentCardRepository.existsByBankAccountNumber("2222"));
        List<PaymentCardData>  isCardExist = new ArrayList<>();
        isCardExist = paymentCardRequest.getPaymentCardData().stream().filter(
                paymentCard ->
                    !paymentCardRepository.existsByBankAccountNumber(paymentCard.getBankAccountNumber()))
        .collect(Collectors.toList());

        if(!isCardExist.isEmpty()) {
            cardsToAdd = paymentCardRequest.getPaymentCardData().stream().map(
                    paymentCard -> {
                        PaymentCard paymentCardResponse = new PaymentCard();
                        paymentCardResponse.setBankAccountNumber(paymentCard.getBankAccountNumber());
                        paymentCardResponse.setBankCardProduct(paymentCard.getBankCardProduct());
                        return paymentCardResponse;
                    }
            ).collect(Collectors.toSet());

        }else{
            throw new Exception("Card is already exist");
        }


       /* for(PaymentCardData  paymentCardData :paymentCardRequest.getPaymentCardData()){
            PaymentCard paymentCard = new PaymentCard();
            paymentCard.setBankAccountNumber(paymentCardData.getBankAccountNumber());
            paymentCard.setBankCardProduct(paymentCardData.getBankCardProduct());
            cardsToAdd.add(paymentCard);

        }*/
        System.out.println("============size "+cardsToAdd.size());

       //cusotmerPaymentCard.addAll(cardsToAdd);
        cusotomer.paymentcards(cardsToAdd);
        customerRepository.saveAndFlush(cusotomer);
    }


    public Set<PaymentCardData> getPaymentCardDetail(String bankCutomerNumber){

         Customer customer =  customerRepository.findByBankCustomerNumber(bankCutomerNumber);
        System.out.println("Total length : "+customer.getPaymentCards().size());
        Set<PaymentCardData> paymentCardDatas = customer.getPaymentCards().stream().map(paycard -> {
           PaymentCardData paymentCardData = new PaymentCardData();
            paymentCardData.setBankAccountNumber(paycard.getBankAccountNumber());
            paymentCardData.setBankCardProduct(paycard.getBankCardProduct());
            return paymentCardData;
        }).collect(Collectors.toSet());

        return paymentCardDatas;
    }

    public PaymentCardDelinkResponse delinkPaymentCard(PaymentCardRequest paymentCardRequest){
        Customer  customer = customerRepository.findByBankCustomerNumber(paymentCardRequest.getBankCustomerNumber());
        System.out.println("====================================== Customer ID :"+ customer.getCustomerId());
        Set<PaymentCard>  allPaymentCard = customer.getPaymentCards();

        PaymentCardDelinkResponse response = new PaymentCardDelinkResponse();

        paymentCardRequest.getPaymentCardData().stream().forEach(paymentcard -> {
                  for(Iterator<PaymentCard> cardIterator = allPaymentCard.iterator(); cardIterator.hasNext();){
                      PaymentCard card = cardIterator.next();
                      if((card.getBankAccountNumber().equalsIgnoreCase(paymentcard.getBankAccountNumber())
                           && card.getBankCardProduct().equalsIgnoreCase(paymentcard.getBankCardProduct()))){
                          PaymentcardStatus paymentcardStatus =  new PaymentcardStatus();
                          paymentcardStatus.setBankAccountNumber(card.getBankAccountNumber());
                          paymentcardStatus.setStatus("De-Linked");
                          cardIterator.remove();
                          paymentCardRepository.save(card);
                     }
                  }
        });
        return null;
    }




}
