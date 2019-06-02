package com.sudesh.org.rewards.controller;

import com.sudesh.org.rewards.data.CustomerRequest;
import com.sudesh.org.rewards.model.Customer;
import com.sudesh.org.rewards.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SU20026464 on 2/2/2019.
 */

@Api
@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

     @PostMapping("/enroll")
    public void enrollCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.enrollCustomer(customerRequest);
    }

}
