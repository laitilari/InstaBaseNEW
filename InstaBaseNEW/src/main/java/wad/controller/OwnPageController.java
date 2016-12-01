package wad.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@Controller
public class OwnPageController {

    @Autowired
    private ImageRepository irepo;
    @Autowired
    private AccountRepository arepo;

    @RequestMapping("/profile")
    public String ProfileDefault(Authentication a, Model model) {
        Account acc = arepo.findByUsername(a.getName());
        if (a == null) {
            model.addAttribute("kuvat", new ArrayList<>());
        } else {
            model.addAttribute("kuvat", acc.getImages());
        }

        return "ownPage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String addImage(Authentication a, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.getContentType().equals("image/png")) {
            return "redirect:/profile";
        }
        Image i = new Image();
        Account acc = arepo.findByUsername(a.getName());
        i.setAccount(acc);
        i.setContent(file.getBytes());
        acc.getImages().add(i);
        irepo.save(i);
        arepo.save(acc);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.DELETE)
    public String deleteImage(@PathVariable Long id) {

        irepo.delete(id);

        return "redirect:/profile";
    }

}
