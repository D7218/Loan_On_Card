package com.lon.LoanService.service;

import com.lon.LoanService.entity.Loan;

import java.util.List;


public interface LoanService {

    Loan createLoan(Loan loan);

    Loan getLoanById(Long loanId);

    List<Loan> getLoansByCustomerId(Long customerId);

    Loan approveLoan(Long loanId);

    void deleteLoan(Long loanId);
}
