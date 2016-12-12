package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.domain.HashTag;
import wad.repository.AccountRepository;
import wad.repository.HashTagRepository;
import wad.service.ImageService;
import wad.service.LogService;

@Controller
@RequestMapping("/hashtag")
public class HashTagController {

    @Autowired
    private HashTagRepository hashRepo;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LogService logService;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hashTagPageDefault(Authentication a, Model model, @PathVariable Long id) {
        
        HashTag ht = hashRepo.findOne(id);

        model.addAttribute("images", imageService.reverseImageList(ht.getImages()));
        model.addAttribute("hashtag", ht.getTag());
        Account account = accountRepository.findByUsername(a.getName());
        logService.addLog("GET /hashtag/" + id, account);

        return "HashTagPage";
    }

}
