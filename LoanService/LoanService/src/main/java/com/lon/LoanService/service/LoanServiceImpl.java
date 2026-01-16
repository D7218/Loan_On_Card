package com.lon.LoanService.service;

import com.lon.LoanService.entity.Loan;
import com.lon.LoanService.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepo repository;

    @Override
    public Loan createLoan(Loan loan) {
        loan.setStatus("PENDING");
        loan.setCreatedDate(LocalDate.now());

        if (loan.getAmount()>10000){
            loan.setInterestRate(12.5);
        }else{
            loan.setInterestRate(10.5);
        }
        return repository.save(loan);
    }
    @Override
    public List<Loan> getAll(){
        return repository.findAll();
}
    @Override
    public Loan getLoanById(Long loanId) {
        return repository.findById(loanId)
                .orElseThrow(()->new RuntimeException("Loan not found with id:" + loanId));
    }

    @Override
    public List<Loan> getLoansByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public Loan approveLoan(Long loanId) {
        Loan loan = getLoanById(loanId);
        loan.setStatus("APPROVED");
        loan.setApprovedDate(LocalDate.now());
        return repository.save(loan) ;
    }

    @Override
    public void deleteLoan(Long loanId) {
        if (!repository.existsById(loanId)) {
            throw new RuntimeException("Loan not found with id:" + loanId);

        }
        repository.deleteById(loanId);

    }
}
