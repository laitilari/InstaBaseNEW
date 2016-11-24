/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ilarilai
 */
@Controller
public class ImageController {

    @RequestMapping("*")
    @ResponseBody
    public String handleDefault() {
        return "asd";
    }
}
