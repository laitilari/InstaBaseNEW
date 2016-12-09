package wad.controller;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.repository.AccountRepository;

@Controller
public class RegisterController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ModelAttribute
    private Account getAccount() {
        return new Account();
    }
    
    @RequestMapping("/register")
    public String Home() {

        return "RegisterPage";
    }

    @RequestMapping(value = "/register/createuser", method = RequestMethod.POST)
    public String createNewUser(@Valid @ModelAttribute Account account, BindingResult bindigResult) {
        if (bindigResult.hasErrors()) {
            return "RegisterPage";
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setAuthorities(Arrays.asList("USER"));

        accountRepo.save(account);
        
        return "redirect:/";
    }

}