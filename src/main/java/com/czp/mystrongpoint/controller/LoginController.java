package com.czp.mystrongpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class LoginController {

    @GetMapping("/index")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        @RequestParam(required = false) boolean rememberMe, Model model) {
        System.out.println(email);
        System.out.println(password);
        System.out.println(rememberMe);
        return "login";
    }

}
