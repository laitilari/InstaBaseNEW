
package wad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnPageController {
    
    
    @RequestMapping("/profile")
    public String ProfileDefault(){
 
        return "ownPage";
    }
    
}
