package com.codeup.blog.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//    @GetMapping("/")
//    @ResponseBody
//    public String hello(){
//        return "This is the landing page";
//    }

        @GetMapping("/")
        public String welcome() {
            return "index";
        }
}
