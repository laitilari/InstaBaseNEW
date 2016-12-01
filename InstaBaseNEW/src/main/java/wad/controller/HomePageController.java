package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Account;
import wad.repository.AccountRepository;

@Controller
public class HomePageController {

    @Autowired
    AccountRepository accountRepo;

    @RequestMapping("*")
    public String Home() {

        return "homePage";
    }
<<<<<<< HEAD

=======
    
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createNewUser(@RequestParam String username, @RequestParam String password){
        if(accountRepo.findByUsername(username) != null){
            return "homePage";
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountRepo.save(account);
        
        return "redirect:/";
    }
    
   
    
    
    
    
>>>>>>> 878149c9e9b1f18d93fd194096140d299fa7cc9d
}
