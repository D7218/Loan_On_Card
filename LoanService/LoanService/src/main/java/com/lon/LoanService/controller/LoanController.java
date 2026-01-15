package com.lon.LoanService.controller;

import com.lon.LoanService.entity.Loan;
import com.lon.LoanService.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("")
      public ResponseEntity<Loan> createLoan( @RequestBody Loan loan){
        return new ResponseEntity<>(service.createLoan(loan), HttpStatus.CREATED);
    }
    // getLoan by Id
    @GetMapping("/{loanId}")
   public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId){
        return ResponseEntity.ok(service.getLoanById(loanId));
   }
   @GetMapping("/customer/{customerId}")
   public ResponseEntity<List<Loan>> getLoanByCustomerId( @PathVariable Long customerId){
    return ResponseEntity.ok(service.getLoansByCustomerId(customerId));
   }
   @PutMapping("/{loanId}/approve")
   public ResponseEntity<Loan> approvedLoan(@PathVariable Long loanId){
        return ResponseEntity.ok(service.approveLoan(loanId));
   }
   public ResponseEntity<String> deleteLoan (@PathVariable Long loanId){
        service.deleteLoan(loanId);
        return ResponseEntity.ok("Loan deleted Successfully");
   }

}
