package com.lon.TransactionService.controller;

import com.lon.TransactionService.entity.Transaction;
import com.lon.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("")
    public List<Transaction> CreateOne(@RequestBody Transaction transaction){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getALlTransaction()).getBody();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        return service.getTransactionById(id);
    }
    @GetMapping
    public List<Transaction> getTransaction(){
        return service.getALlTransaction();
    }
}
