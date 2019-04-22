package com.example.apimanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liulingling
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String index() {

        return "index";
    }
}
