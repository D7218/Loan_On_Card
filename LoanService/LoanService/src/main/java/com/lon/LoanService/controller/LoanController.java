package com.lon.LoanService.controller;

import com.lon.LoanService.entity.Loan;
import com.lon.LoanService.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("/apply")
    public Loan apply(@RequestBody Loan loan){
        return service.applyLoan(loan);
    }
}
