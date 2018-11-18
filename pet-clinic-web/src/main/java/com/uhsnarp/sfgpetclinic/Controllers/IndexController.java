package com.uhsnarp.sfgpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/","index","index.html"})
    String index(){
        return "index";
    }

    @RequestMapping("/oups")
    public String oops(){
        return "notImplemented";
    }
}
