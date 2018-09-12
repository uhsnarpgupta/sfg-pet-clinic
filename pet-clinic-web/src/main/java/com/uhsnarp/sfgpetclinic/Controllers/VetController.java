package com.uhsnarp.sfgpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping({"","/vets","/vets/index","/vets/index.html"})
    String listVets(){
        return "vets/index";
    }
}
