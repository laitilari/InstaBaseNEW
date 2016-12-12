package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import wad.repository.LogRepository;
import wad.service.LogService;

@Controller
public class ImageController {

    @Autowired
    ImageRepository imageRepo;
    @Autowired
    AccountRepository aRepo;
    @Autowired
    CommentRepository commentRepo;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/image/{id}/content", method = RequestMethod.GET, produces = "image/png")
    @ResponseBody
    @Transactional(readOnly = true)
    public byte[] getContent(Authentication a, @PathVariable Long id) {
        Account account = aRepo.findByUsername(a.getName());
        return imageRepo.findOne(id).getContent();

    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public String imagePageDefault(Authentication a, Model model, @PathVariable Long id) {
        Image image = imageRepo.getOne(id);
        model.addAttribute("kuva", image);
        model.addAttribute("numberOfLikes", image.getLikes());
        model.addAttribute("comments", image.getCommentList());
        model.addAttribute("hashtags", image.getHashTags());
        model.addAttribute("title", image.getAccount().getUsername() + "'s image");
         model.addAttribute("account", aRepo.findByUsername(a.getName()));

        Account account = aRepo.findByUsername(a.getName());
        logService.addLog("GET /image/{id}, Loaded image with id = " + id, account);

        return "imagePage";
    }

    @RequestMapping(value = "/image/{id}/like", method = RequestMethod.POST)
    public String imagePageAddLike(Authentication a, @PathVariable Long id) {
        Account account = aRepo.findByUsername(a.getName());
        Image i = imageRepo.findOne(id);
        i.getLikesSet().add(account);
        imageRepo.save(i);
        logService.addLog("POST /image/{id}, Liked an image with id = " + id, account);
        return "redirect:/image/" + id;
    }

    @RequestMapping(value = "/image/{id}/comment", method = RequestMethod.POST)
    public String imagePageComment(Authentication a, @PathVariable Long id, @RequestParam String comment) {
        Comment c = new Comment();
        c.setContent(comment);
        Account account = aRepo.findByUsername(a.getName());
        c.setAccount(account);
        commentRepo.save(c);
        account.addComment(c);
        aRepo.save(account);
        Image i = imageRepo.getOne(id);
        i.getCommentList().add(c);
        imageRepo.save(i);
        logService.addLog("POST /image/{id}, Commented on image with id = " + id, account);
        return "redirect:/image/" + id;
    }

}
