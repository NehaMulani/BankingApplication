package com.example.registrationlogindemo.Transaction;

import com.example.registrationlogindemo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public void save(Transaction t) {
        transactionRepository.save ( t );
    }

    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }


    public void deposit(String accountNumber, double depositAmount){
        Transaction transaction = transactionRepository.findById ( Integer.valueOf ( accountNumber ) ).orElse ( null );
        if (transaction!= null){
            transaction.setBalance(transaction.getBalance() + depositAmount);
            transactionRepository.save ( transaction );
        }
    }

    public void withdraw(int id, double withdrawAmount){
        Transaction transaction = transactionRepository.findById ( id ).orElse ( null );
        if (transaction!= null && transaction.getBalance() >= withdrawAmount){
            transaction.setBalance(transaction.getBalance() - withdrawAmount);
            transactionRepository.save ( transaction );
        }
    }


}