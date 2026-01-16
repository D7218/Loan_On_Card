package com.lon.LoanService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan_service")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long customerId;
    
    private Long cardId;
    private Double amount;
    private String status;
    private Double interestRate;
    private Integer tenure;
    private LocalDate createdDate;
    private LocalDate approvedDate;


}
