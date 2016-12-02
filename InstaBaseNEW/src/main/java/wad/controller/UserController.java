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
    AccountRepository arepo;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long id) {
        Account account = arepo.findOne(id);
       
        model.addAttribute("user", account);
        model.addAttribute("userspage", account.getUsername()+"'s profile");
        model.addAttribute("images", account.getImages());
        model.addAttribute("followersSize", account.getFollowers().size());
        model.addAttribute("users", arepo.findAll());
        
//        model.addAttribute("followers", account.getFollowers().size());
        return "userPage";
    }

}
