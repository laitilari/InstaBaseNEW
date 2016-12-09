package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.HashTag;
import wad.repository.HashTagRepository;

@Controller
@RequestMapping("/hashtag")
public class HashTagController {
    
    @Autowired
    private HashTagRepository hashRepo;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String hashTagPageDefault(Model model, @PathVariable Long id) {
        HashTag ht = hashRepo.findOne(id);
        model.addAttribute("images", ht.getImages());
        model.addAttribute("hashtag", ht.getTag());

        return "HashTagPage";
    }
    
}
