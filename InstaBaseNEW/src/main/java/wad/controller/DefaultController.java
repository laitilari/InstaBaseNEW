package wad.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.repository.AccountRepository;

@Profile("production")
@Controller
public class DefaultController {

    @Autowired
    AccountRepository accountRepo;

    @RequestMapping("*")
    public String Home(Authentication a) {

        if(a != null && a.isAuthenticated()){
            return "redirect:/home";
        }
        return "login";
    }


}
