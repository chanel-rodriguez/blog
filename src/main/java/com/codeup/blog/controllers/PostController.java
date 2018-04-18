package com.codeup.blog.controllers;

import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts",postSvc.allPosts());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable int id, Model model){
        model.addAttribute("post", postSvc.singlePost(id));
        return "posts/show";
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
