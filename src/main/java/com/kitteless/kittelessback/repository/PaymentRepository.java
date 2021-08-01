package com.kitteless.kittelessback.repository;

import com.kitteless.kittelessback.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findPaymentsByUserId(String userId);

    @Query("SELECT p FROM Payment p WHERE p.stampCode = :stampCord")
    Payment findByStampCord(String stampCord);
}
