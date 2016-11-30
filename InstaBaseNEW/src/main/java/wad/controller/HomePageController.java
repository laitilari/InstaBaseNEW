/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Account;
import wad.repository.AccountRepository;

/**
 *
 * @author Otto
 */
@Controller
public class HomePageController {
    
    @Autowired
    AccountRepository accountRepo;
    
    @RequestMapping("*")
    public String Home(){
        
        return "homePage";
    }
    
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createNewUser(@RequestParam String username, @RequestParam String password){
        if(accountRepo.findByUsername(username) != null){
            return "homePage";
        }
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountRepo.save(account);
        
        
        return "redirect:/";
    }
    
   
    
    
    
    
}
