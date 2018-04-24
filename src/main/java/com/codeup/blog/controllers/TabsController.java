package com.codeup.blog.controllers;

import com.codeup.blog.repositories.CategoryRepository;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TabsController {

    private PostRepository postDao;
    private CategoryRepository categoryDao;

    public TabsController(PostRepository postDao, CategoryRepository categoryDao) {
        this.postDao = postDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/aboutme")
    public String aboutMe(Model model) {
        model.addAttribute("categories",categoryDao.findAll());
        return"/tabs/aboutMe";
    }

    @GetMapping("/shortstories")
    public String shortStories(Model model){
        model.addAttribute("posts", postDao.findByType("short_story"));
        return"/tabs/shortStories";
    }

    @GetMapping("/personalnarrative")
    public String PersonalNarrative(Model model){
        model.addAttribute("posts", postDao.findByType("personal_narrative"));
        return"/tabs/personalNarrative";
    }

    @GetMapping("/bookclub")
    public String bookClub(Model model){
        model.addAttribute("posts", postDao.findByType("book_club"));
        return"/tabs/bookClub";
    }
}
