package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TabsController {

    @GetMapping("/aboutme")
    public String aboutMe(){
        return"/tabs/aboutMe";
    }
}
