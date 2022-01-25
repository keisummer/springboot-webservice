package com.keisummer.webservice.controller;

import com.keisummer.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("data", "keisummer");
        model.addAttribute("posts", postsService.findAll());
        return "main";
    }
}
