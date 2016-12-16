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
import wad.service.LogService;

@Controller
public class RegisterController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LogService logService;

    @ModelAttribute
    private Account getAccount() {
        return new Account();
    }

    @PostConstruct
    public void init() {
        if (accountRepo.findByUsername("pekka")!= null) {
            return;
        }
        Account pekka = new Account();
        pekka.setUsername("pekka");
        pekka.setPassword(passwordEncoder.encode("pekka"));
        pekka.setAuthorities(Arrays.asList("USER", "ADMIN"));
        accountRepo.save(pekka);
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
        account = accountRepo.save(account);
        if (account.getId() == null) {
            System.out.println("error!");
            return "redirect:/";
        }
        logService.addLog("New account was created with name = " + account.getUsername(), account);

        return "redirect:/";
    }

}
