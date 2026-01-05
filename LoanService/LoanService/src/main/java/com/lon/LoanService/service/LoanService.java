package com.lon.LoanService.service;

import com.lon.LoanService.entity.Loan;
import com.lon.LoanService.kafkaProducer.LoanEventProducer;
import com.lon.LoanService.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepo repository;

    @Autowired
    private LoanEventProducer producer;

    public Loan applyLoan(Loan loan) {
        loan.setStatus("APPROVED");
        Loan savedLoan = repository.save(loan);

        // Publish Kafka event
        producer.sendLoanApprovedEvent(savedLoan.getId());

        return savedLoan;
    }
}
