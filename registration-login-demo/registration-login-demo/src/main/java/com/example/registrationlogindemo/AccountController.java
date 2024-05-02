package com.example.registrationlogindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    //Register Account Controller
    @GetMapping("/account_register")
    public String accountRegister() {
        return "accountRegister";
    }

    //Available Accounts Controller
    @GetMapping("/available_accounts")
    public ModelAndView getAllAccount() {
        List<Account> list=service.getAllAccount ();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("accountList");
//		m.addObject("account",list);
        return new ModelAndView("accountList","account",list);
    }

    //New Account Save Form Method Controller
    @PostMapping("/save")
    public String addAccount(@ModelAttribute Account a) {
        service.save(a);
        return "redirect:/available_accounts";
    }
    /*@PostMapping("/save")
    public ResponseEntity<String> registerAccount(@RequestBody Account a){
        // Validate the password and confirm password fields
        if (!a.getAccountNumber ().equals ( a.getConfirmAccountNumber () )){
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST).body ( "Passwords do not match" );
        }

        // If validation passes, continue with registration process
        // (e.g., save user data to database, send confirmation email, etc.)
        return ResponseEntity.ok ("Registration Successful");
    }*/

   /* @GetMapping("/view_transactions")
    public String transactionList() {
        return "transactionList";
    }*/
    /*@GetMapping("/view_transaction")
    public ModelAndView getAllTransaction() {
        List<Account> list=service.getAllTransaction ();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("accountList");
//		m.addObject("account",list);
        return new ModelAndView("transactionList","account",list);
    }
    @PostMapping("/go")
    public String searchTransaction(@ModelAttribute Account a) {
        service.save(a);
        return "redirect:/view_transactions";
    }*/

    //Deposit Amount Controller
    @RequestMapping("/depositAmount/{id}")
    public String depositAmount(@PathVariable("id") int id,Model model) {
        Account a=service.getAccountById(id);
        model.addAttribute("account",a);
        return "deposit";
    }

    /*@PostMapping("/deposit")
    public String submitForm(@ModelAttribute("account") Account account) {
        System.out.println(account);
        return "deposit_success";
    }*/

    /*@PostMapping("/deposit")
    public String deposit(@PathVariable int id, @RequestParam double depositAmount){
        service.deposit (id, depositAmount );
        return "redirect:/available_accounts";
    }*/

    /*@PostMapping("/withdraw")
    public String withdraw(@PathVariable int id, @RequestParam double amount){
        service.withdraw ( id, amount );
        return "redirect:/available_accounts";
    }
*/
    //Withdraw Amount Controller
    @RequestMapping("/withdrawAmount/{id}")
    public String withdrawAmount(@PathVariable("id") int id,Model model) {
        Account a=service.getAccountById(id);
        model.addAttribute("account",a);
        return "withdraw";
    }
    /*@PostMapping("/withdraw")
    public String withdrawSubmitForm(@ModelAttribute("account") Account account) {
        System.out.println(account);
        return "withdraw_success";
    }*/

    /*@PostMapping("/add")
    public String saveTransaction(@ModelAttribute Account a) {
        service.save(a);
        return "redirect:/available_accounts";
    }
*/
    //Select Account Controller
    @RequestMapping("/viewStatement/{id}")
    public String viewStatement(@PathVariable("id") int id,Model model) {
        Account a=service.getAccountById(id);
        model.addAttribute("account",a);
        return "accountStatement";
    }

    //Delete Account Controller
    @RequestMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_accounts";
    }

}
