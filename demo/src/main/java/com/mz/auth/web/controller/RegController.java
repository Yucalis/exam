package com.mz.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegController {

    @RequestMapping("gotoReg")
    public String gotoReg() {
        return "views/reg";
    }


}
