package com.lon.TransactionService.repository;

import com.lon.TransactionService.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
