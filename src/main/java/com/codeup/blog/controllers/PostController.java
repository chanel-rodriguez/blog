package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
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
    public String posts(@PathVariable long id, Model model){
        model.addAttribute("post", postSvc.singlePost(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(Model model){
        model.addAttribute("post",new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreateForm(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("editPost", postSvc.singlePost(id));
        return "/posts/create";
    }
    @PostMapping("/posts/edit")
    public String editPostForm(@ModelAttribute Post post){
        postSvc.edit(post);
        return "redirect:/posts";
    }
}
