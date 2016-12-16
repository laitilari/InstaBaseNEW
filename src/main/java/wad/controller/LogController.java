/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.service.LogService;

/**
 *
 * @author ottomaki
 */
@Controller
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping()
    public String Logs(Authentication a, Model model) {
        if (a.getAuthorities().size() == 2) {
            model.addAttribute("logs", logService.getLogs());
            return "LogPage";
        }
        return "redirect:/";
    }
}
