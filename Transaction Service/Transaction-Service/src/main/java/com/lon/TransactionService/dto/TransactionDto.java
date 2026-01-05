package com.lon.TransactionService.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TransactionDto {


    private Long customerId;
    private Long loanId;
    private Double amount;
    private String status;
}
