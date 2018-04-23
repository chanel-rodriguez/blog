package com.codeup.blog.controllers;


import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userDao;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user/login")
    public String login(){
        return null;
    }

    @PostMapping("/user/create")
    public String register(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String password, Model model){
//        System.out.println("testing" + firstName);
        User user = new User(firstName, lastName, email, password);
        userDao.save(user);
        return "redirect:/posts";
    }

}
