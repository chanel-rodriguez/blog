package com.codeup.blog.controllers;

import com.codeup.blog.services.NumberUrlService;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class NumberUrlController {

    private NumberUrlService data;
    public NumberUrlController(NumberUrlService x) {
        this.data =x;
    }

    @GetMapping("/math/{n}/")
    public String calculate(@PathVariable double n, Model model){
        System.out.println(n);
    HashMap<String, Double> stuff = new HashMap<>();
    stuff.put("perimeter", data.perimeter(n));
    stuff.put("area", data.area(n));
    stuff.put("volume", data.volume(n));
    stuff.put("circle", data.circleArea(n));
    stuff.put("circumference", data.circumference(n));
    stuff.put("isPrime", data.isPrime(n));
    model.addAttribute("hashmap",stuff);
    return "mathPage";
    }
}
