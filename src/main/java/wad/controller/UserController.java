package wad.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.AccountRepository;
import wad.service.ImageService;

@Controller
public class UserController {

    @Autowired
    AccountRepository arepo;
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long id) {
        Account account = arepo.findOne(id);
       
        model.addAttribute("images", imageService.reverseImageList(account.getImages()));
        model.addAttribute("user", account);
        model.addAttribute("userspage", account.getUsername() + "'s profile");
        model.addAttribute("users", arepo.findAll());
        return "userPage";
    }

}
