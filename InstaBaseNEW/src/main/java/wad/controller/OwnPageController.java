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
    public String ProfileDefault(Model model) {
        
        model.addAttribute("kuvat", irepo.findAll());
        return "ownPage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String addImage(Authentication a, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.getContentType().equals("image/png")) {
            return "redirect:/profile";
        }
        System.out.println(a.getCredentials());
        Image i = new Image();
        System.out.println(a.getName());
        i.setAccount(arepo.findByUsername(a.getName()));
        
        i.setContent(file.getBytes());
        irepo.save(i);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.DELETE)
    public String deleteImage(@PathVariable Long id) {

        irepo.delete(id);

        return "redirect:/profile";
    }

}
