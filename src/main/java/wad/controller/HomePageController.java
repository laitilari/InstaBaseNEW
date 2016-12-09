package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.AccountRepository;
import wad.repository.ImageRepository;
import wad.service.HashTagService;
@Controller
public class HomePageController {

    @Autowired
    private ImageRepository irepo;
    @Autowired
    private AccountRepository arepo;
    @Autowired
    private HashTagService hashTagService;

    @RequestMapping("/home")
    public String ProfileDefault(Authentication a, Model model) {
        Account acc = arepo.findByUsername(a.getName());
        if (a == null) {
            return "redirect:/";
        } else {
            model.addAttribute("kuvat", acc.getImages());
            model.addAttribute("accountid", acc.getId());
            model.addAttribute("users", arepo.findAll());
        }

        return "homePage";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String addImage(Authentication a, @RequestParam("file") MultipartFile file, @RequestParam String caption) throws IOException {
        if (!file.getContentType().equals("image/png")) {
            return "redirect:/home";
        }
        Image i = new Image();
        Account acc = arepo.findByUsername(a.getName());
        i.setAccount(acc);
        i.setCaption(caption);
        i.setContent(file.getBytes());
        acc.getImages().add(i);
        irepo.save(i);
        arepo.save(acc);
        hashTagService.addHashTags(i.getId());

        return "redirect:/home";
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.DELETE)
    public String deleteImage(@PathVariable Long id) {
        Image i = irepo.findOne(id);
        Account acc = arepo.findOne(i.getAccount().getId());
        acc.getImages().remove(i);
        arepo.save(acc);
        irepo.delete(id);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home/delete/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable Long id) {
        arepo.delete(id);
        return "redirect:/home";
    }

}
