package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.repository.AccountRepository;
import wad.repository.LogRepository;
import wad.service.ImageService;
import wad.service.LogService;

@Controller
public class UserController {

    @Autowired
    AccountRepository arepo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long id) {
        Account account = arepo.findOne(id);
        model.addAttribute("images", imageService.reverseImageList(account.getImages()));
        model.addAttribute("user", account);
        model.addAttribute("userspage", account.getUsername() + "'s profile");
        model.addAttribute("users", arepo.findAll());
        model.addAttribute("account", account);
        logService.addLog("GET /user/{id}, Loaded user's page with id = " + id, account);
        return "userPage";
    }

}
