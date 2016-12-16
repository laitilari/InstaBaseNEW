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
import wad.repository.LogRepository;
import wad.service.HashTagService;
import wad.service.ImageService;
import wad.service.LogService;

@Controller
public class HomePageController {

    @Autowired
    private ImageRepository irepo;
    @Autowired
    private AccountRepository arepo;
    @Autowired
    private HashTagService hashTagService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LogService logService;

    @RequestMapping("/home")
    public String ProfileDefault(Authentication a, Model model) {
        Account account = arepo.findByUsername(a.getName());
        if (account == null) {
            return "redirect:/";
        } else {
            model.addAttribute("kuvat", imageService.reverseImageList(account.getImages()));
            model.addAttribute("accountid", account.getId());
            model.addAttribute("users", arepo.findAll());
            model.addAttribute("account", account);
        }

        logService.addLog("GET /home", account);

        return "homePage";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String addImage(Authentication a, @RequestParam("file") MultipartFile file, @RequestParam String caption) throws IOException {
        if (!file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpeg")) {
            return "redirect:/home";
        }
        Image i = new Image();
        Account account = arepo.findByUsername(a.getName());
        i.setAccount(account);
        i.setCaption(caption);
        i.setContent(file.getBytes());
        account.getImages().add(i);
        i = irepo.save(i);
        account = arepo.save(account);
        hashTagService.addHashTags(i.getId());
        logService.addLog("POST /home, Added image with id = " + i.getId(), account);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.DELETE)
    public String deleteImage(Authentication a, @PathVariable Long id) {
        Image i = irepo.findOne(id);
        Account account = arepo.findOne(i.getAccount().getId());
        account.getImages().remove(i);
        arepo.save(account);
        irepo.delete(id);

        logService.addLog("DELETE /home/{id}, Deleted image with id = " + i.getId(), account);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home/{id}/english", method = RequestMethod.POST)
    public String changeLanguageToEnglish(Authentication a, @PathVariable Long id) {
        Account account = arepo.findOne(id);
        account.setFinnish(false);
        arepo.save(account);
        logService.addLog("POST /home/{id}/english, User changed language to english", account);
        return "redirect:/home";
    }
    
     @RequestMapping(value = "/home/{id}/finnish", method = RequestMethod.POST)
    public String changeLanguageToFinnish(Authentication a, @PathVariable Long id) {
        Account account = arepo.findOne(id);
        account.setFinnish(true);
        arepo.save(account);
        logService.addLog("POST /home/{id}/finnish, User changed language to finnish", account);
        return "redirect:/home";
    }

}
