package com.example.TransactionServiceApplication.repository;


import com.example.TransactionServiceApplication.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn, Integer> {
}