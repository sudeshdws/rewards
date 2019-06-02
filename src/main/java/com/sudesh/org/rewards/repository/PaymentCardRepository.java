package com.sudesh.org.rewards.repository;

import com.sudesh.org.rewards.model.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SU20026464 on 2/2/2019.
 */
@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard,Long> {
    Boolean existsByBankAccountNumber(String bankAccountNumber);

    int deleteByPaymentCardId(Long Long);
    void deleteById(Long aLong);
}
