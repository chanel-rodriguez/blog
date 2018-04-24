package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.models.UserWithRoles;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
        User curUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!curUser.getEmail().equals("zarcodiane@gmail.com")){
            return "redirect:/";
        }
        model.addAttribute("post",new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreateForm(@ModelAttribute Post post){
        User curUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(curUser.getEmail());
        System.out.println(curUser.getFirstName());
        System.out.println(curUser.getId());
        System.out.println(userDao.findOne(curUser.getId()).getUsername());
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
