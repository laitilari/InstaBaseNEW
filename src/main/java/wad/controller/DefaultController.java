package wad.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.repository.AccountRepository;
import wad.repository.LogRepository;
import wad.service.LogService;

@Controller
public class DefaultController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    private LogService logService;

    @RequestMapping("*")
    public String Home(Authentication a) {

        if (a != null && a.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }

}
