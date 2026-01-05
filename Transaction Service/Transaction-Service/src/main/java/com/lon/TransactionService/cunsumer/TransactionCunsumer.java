package com.lon.TransactionService.cunsumer;

import com.lon.TransactionService.dto.TransactionDto;
import com.lon.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class TransactionCunsumer {

    @Autowired
    private TransactionService service;

    @KafkaListener(topics = "loan-approved-topics",
                    groupId = "transaction-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void cunsume(TransactionDto event){
        service.createTransaction(event);
    }

}

