package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"Some Post","this is something about something that i wrote"));
        posts.add(new Post(2,"Somewhere Post","this is something about something that i wrote when i was in somewhere"));
        model.addAttribute("posts",posts);
//  return "This would return the Posts Index page";
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable long id, Model model){
        Post post = new Post(id, "First Post","Welcome to my first blog site; i hope you enjoy it!");
        model.addAttribute("post", post);
        //        return "Page for post id: " + id;
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
