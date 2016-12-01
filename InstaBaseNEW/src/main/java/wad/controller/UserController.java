package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.AccountRepository;

@Controller
public class UserController {

    @Autowired
    AccountRepository accountRepo;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long id) {
        Account account = accountRepo.findOne(id);
        System.out.println(account.getImages().size());
        model.addAttribute("images", account.getImages());
        model.addAttribute("followersSize", account.getFollowers().size());
        
//        model.addAttribute("followers", account.getFollowers().size());
        return "userPage";
    }

}
