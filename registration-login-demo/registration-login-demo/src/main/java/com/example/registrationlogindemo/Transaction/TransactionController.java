package com.example.registrationlogindemo.Transaction;

import com.example.registrationlogindemo.Account;
import com.example.registrationlogindemo.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private AccountService service;
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/view_transactions")
    public String transactionList() {
        return "transactionList";
    }
    @GetMapping("/view_transaction")
    public ModelAndView getAllTransaction() {
        List<Transaction> list=transactionService.getAllTransaction ();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("accountList");
//		m.addObject("account",list);
        return new ModelAndView("transactionList","transaction",list);
    }
    @PostMapping("/go")
    public String searchTransaction(@ModelAttribute Account a) {
        service.save(a);
        return "redirect:/view_transaction";
    }

    //Deposit Amount Controller

    @PostMapping("/deposit")
    public String deposit(@PathVariable String accountNumber, @RequestParam double depositAmount){
        transactionService.deposit (accountNumber, depositAmount );
        return "redirect:/view_transaction";
    }


}
