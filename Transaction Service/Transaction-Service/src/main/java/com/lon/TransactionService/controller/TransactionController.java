package com.lon.TransactionService.controller;

import com.lon.TransactionService.entity.Transaction;
import com.lon.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        return service.getTransactionById(id);
    }
    @GetMapping
    public List<Transaction> getTransaction(){
        return service.getALlTransaction();
    }
}
