package com.example.registrationlogindemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;

    //Index Page Controller
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    //Register Page Controller
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    //Process Register Controller
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    //Home Page Controller
    @GetMapping("/home")
    public String home(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "home";
    }

    //Save User Controller
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

   /* @GetMapping("/accountsList")
    public String listAccounts(Model model) {
        List<Account> listAccounts = accountRepository.findAll();
        model.addAttribute("listAccounts", listAccounts);
        return "accountsList";
    }*/

    //Account Statement Controller
    /*@GetMapping("/account_statement")
    public String accountStatement(){
        return "accountStatement";
    }

    //Deposit Amount Controller
    @GetMapping("/deposits")
    public String getTransaction(){
        return "deposit";
    }

    //Withdraw Amount Controller
    @GetMapping("/withdraw")
    public String withdrawAmount(){
        return "withdraw";
    }*/
}
