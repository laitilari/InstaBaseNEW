package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Account;
import wad.repository.AccountRepository;

@Controller
public class RegisterController {

    @Autowired
    AccountRepository accountRepo;
    
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
//        if(accountRepo.findByUsername(username) != null){
//            return "homePage";
//        }
//        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        accountRepo.save(account);
        if (bindigResult.hasErrors()) {
            System.out.println("Error");
            return "RegisterPage";
        }

        accountRepo.save(account);
        
        System.out.println(account.getId());
        return "redirect:/";
    }

}
