package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Image;
import wad.repository.ImageRepository;

@Controller
public class OwnPageController {
    @Autowired
    private ImageRepository irepo;

    @RequestMapping("/profile")
    public String ProfileDefault() {

        return "ownPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.getContentType().equals("image/png")) {
            return "redirect:/profile";
        }

        Image i = new Image();
        i.setContent(file.getBytes());
        irepo.save(i);

        return "redirect:/profile";
    }

}
