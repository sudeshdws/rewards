package com.sudesh.org.rewards.repository;

import com.sudesh.org.rewards.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by SU20026464 on 2/2/2019.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByBankCustomerNumber(String bankCustomerNumber);



//    @Query("SELECT  CUST.CUSTOMER_ID   FROM CUSTOMER CUST WHERE CUST.BANK_CUSTOMER_NUMBER  = 'bankCustomerNumber'")
//    Long getCustomerId(@Param("bankCustomerNumber") String bankCustomerNumber);


}
