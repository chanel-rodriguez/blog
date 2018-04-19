package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostService postSvc;
    private PostRepository postDao;

    public PostController(PostService postSvc, PostRepository postDao) {
        this.postSvc = postSvc;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts",postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(Model model){
        model.addAttribute("post",new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreateForm(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("editPost", postDao.findOne(id));
        return "/posts/create";
    }
    @PostMapping("/posts/edit")
    public String editPostForm(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post){
        postDao.delete(post);
        return "redirect:/posts";
    }
}
