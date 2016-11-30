/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Account;
import wad.domain.Image;
import wad.repository.AccountRepository;

/**
 *
 * @author Otto
 */

@Controller
public class UserController {
    
    @Autowired
    AccountRepository accountRepo;
    
    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)    
    public String imagePageDefault(Model model, @PathVariable String userid) {
        Account account = accountRepo.findByUsername(userid);        
        model.addAttribute("images", account.getImages());
//        model.addAttribute("followers", account.getFollowers().size());
        return "userPage";
    }
    
    
}
