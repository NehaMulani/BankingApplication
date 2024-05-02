package com.example.registrationlogindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository aRepo;

    public void save(Account a) {
        aRepo.save(a);
    }

    public List<Account> getAllAccount(){
        return aRepo.findAll();
    }

    public Account getAccountById(int id) {
        return aRepo.findById(id).get();
    }
    public void deleteById(int id) {
        aRepo.deleteById(id);
    }

    public Account getTransactionById(int id) {
        return aRepo.findById(id).get();
    }



}
