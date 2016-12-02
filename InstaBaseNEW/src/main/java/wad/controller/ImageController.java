package wad.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.domain.Account;
import wad.domain.Comment;
import wad.domain.Image;
import wad.repository.AccountRepository;
import wad.repository.CommentRepository;
import wad.repository.ImageRepository;

@Controller
public class ImageController {

    @Autowired
    ImageRepository imageRepo;
    @Autowired
    AccountRepository aRepo;
    @Autowired
    CommentRepository commentRepo;

    @RequestMapping(value = "/image/{id}/content", method = RequestMethod.GET, produces = "image/png")
    @ResponseBody
    public byte[] getContent(@PathVariable Long id) {
        return imageRepo.findOne(id).getContent();
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Model model, @PathVariable Long id) {
        Image image = imageRepo.getOne(id);
        model.addAttribute("kuva", image);
        model.addAttribute("numberOfLikes", image.getLikes());
        model.addAttribute("comments", image.getCommentList());
        System.out.println(image.getCommentList().size());

        return "imagePage";
    }

    @RequestMapping(value = "/image/{imageid}/like", method = RequestMethod.POST)
    public String imagePageAddLike(Authentication a, @PathVariable Long imageid) {
        Account acc = aRepo.findByUsername(a.getName());
        Image i = imageRepo.findOne(imageid);
        i.getLikesSet().add(acc);
        imageRepo.save(i);

        return "redirect:/image/" + imageid;
    }

    @RequestMapping(value = "/image/{imageid}/comment", method = RequestMethod.POST)
    public String imagePageComment(Authentication a, @PathVariable Long imageid, @RequestParam String comment) {
        Comment c = new Comment();
        c.setContent(comment);
        Account acc = aRepo.findByUsername(a.getName());
        c.setAccount(acc);
        commentRepo.save(c);
        acc.addComment(c);
        aRepo.save(acc);
        Image i = imageRepo.getOne(imageid);
        i.getCommentList().add(c);
        imageRepo.save(i);
        return "redirect:/image/" + imageid;
    }

}
