package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/{text}/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2){
        return num1 + num2;
    }
    @GetMapping("/subtract/{num1}/{text}/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable String text, @PathVariable int num2){
        if(text.equals("from")){
            return num2 - num1;
        }else{
            return num1 - num2;
        }
    }
    @GetMapping("/multiply/{num1}/{text}/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }
    @GetMapping("/divide/{num1}/{text}/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2){
        return num1 / num2;
    }

    @GetMapping("/roll-dice")
    public String roll (){
        return "rollDice";
    }
    @GetMapping("/roll-dice/{n}")
    public String roll (@PathVariable int n, Model model){
        List<Integer> rolls = new ArrayList<>();
        int correct = 0;
        for(int i =0; i < 10; i ++){
            int number = (int) Math.floor(Math.random()*6)+1;
            if(number == n){ correct++;}
            rolls.add(number);
        }
        model.addAttribute("guess", n);
        model.addAttribute("rolls",rolls);
        model.addAttribute("correct",correct);
        return "rollDice";
    }

}
