package com.tpIntergiciel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by abdel on 18/12/2016.
 */
@Controller
public class WebSiteController {
    @RequestMapping(value={"/", "login"})
    public String accessToLoginPage(Model model) {
        return "login";
    }

    @RequestMapping("/index")
    public String accessToIndex(Model model) {
        return "index";
    }
}
