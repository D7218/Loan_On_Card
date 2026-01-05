package com.lon.LoanService.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoanEventProducer {

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate;

    public void sendLoanApprovedEvent(Long loanId){
        kafkaTemplate.send("loan-approved-topic", "Loan approved :" + loanId);
    }
}
