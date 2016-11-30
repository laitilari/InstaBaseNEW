
package wad.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.domain.Comment;
import wad.domain.Image;
import wad.domain.Likee;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;
import wad.repository.LikeeRepository;


@Controller
public class ImageController {

    @Autowired
    ImageRepository imageRepo;
    @Autowired
    LikeeRepository likeeRepo;
    @Autowired
    CommentRepository commentRepo;

    @RequestMapping(value = "/imagePage/{imageid}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long imageid) {
        Image image = imageRepo.getOne(imageid);
        model.addAttribute("linkToImage", image.getLink());
        model.addAttribute("numberOfLikes", image.getLikes().size());
        model.addAttribute("comments", image.getComments());
        return "imagePage";
    }

    @RequestMapping(value = "/imagePage/{imageid}/like", method = RequestMethod.POST)
    public String imagePageAddLike(@PathVariable String imageid) {
        //NOT YET IMPLEMENTED
        
        return "redirect:/imagePage" + imageid;
    }

    @RequestMapping(value = "/imagePage/{imageid}/comment", method = RequestMethod.POST)
    public String imagePageComment(@PathVariable String imageid, @RequestParam String comment) {
        

        return "redirect:/imagePage" + imageid;
    }

}
