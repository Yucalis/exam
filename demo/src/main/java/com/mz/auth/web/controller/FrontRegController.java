package com.mz.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontRegController {

    @RequestMapping("/front/gotoRegPage")
    public String gotoRegPage() {
        return "front/regIndex";
    }

}
