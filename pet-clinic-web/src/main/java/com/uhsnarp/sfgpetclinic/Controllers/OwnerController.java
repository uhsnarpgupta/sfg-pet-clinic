package com.uhsnarp.sfgpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {
    @RequestMapping({"","/","/index","/index.html"})
    String listOwners(){
        return "owners/index";
    }
}
