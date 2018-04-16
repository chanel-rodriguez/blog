package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "This would return the Posts Index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String posts(@PathVariable long id){
        return "Page for post id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "This would return the Create page";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(@RequestParam String user){
        return "This would have created a new post for user: " + user;
    }
}
