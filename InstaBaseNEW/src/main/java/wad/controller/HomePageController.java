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
}
