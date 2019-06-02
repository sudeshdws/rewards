package com.sudesh.org.rewards.service;

import com.sudesh.org.rewards.data.CustomerRequest;
import com.sudesh.org.rewards.model.Customer;
import com.sudesh.org.rewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SU20026464 on 2/2/2019.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void enrollCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setCustomerToken(customerRequest.getCustomerToken());
        customer.setBankCustomerNumber(customerRequest.getBankCustomerNumber());
        customer.setBussinessPartner(customerRequest.getBussinessPartner());
        customer.setAddress(customerRequest.getAddress());
        customer.setPostalCode(customerRequest.getPostalCode());
        customerRepository.save(customer);
    }

}
