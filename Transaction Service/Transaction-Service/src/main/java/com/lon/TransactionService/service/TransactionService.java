package com.lon.TransactionService.service;

import com.lon.TransactionService.dto.TransactionDto;
import com.lon.TransactionService.entity.Transaction;
import com.lon.TransactionService.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo repository;

    public void createTransaction(TransactionDto event){
        Transaction tx = new Transaction();
        tx.setLoanId(event.getLoanId());
        tx.setCustomerId(event.getCustomerId());
        tx.setAmount(event.getAmount());
        tx.setStatus("DISBURSEMENT");
        tx.setStatus("SUCCESS");
        repository.save(tx);
    }
    public List<Transaction> getALlTransaction(){
        return repository.findAll();
}
    public Transaction getTransactionById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Transaction not found"));
    }

}
