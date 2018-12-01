package com.czp.mystrongpoint.controller;

import com.czp.mystrongpoint.constant.WebConstants;
import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.service.RougeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(path = "/")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RougeService rougeService;

    @GetMapping("/index")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        @RequestParam(required = false) boolean rememberMe, HttpServletRequest request, Model model) {
        Rouge rouge = rougeService.getRougeByEmail(email);
        if (Objects.isNull(rouge)
                || !Objects.equals(rouge.getPassword(), password)) {
            logger.warn("This rouge [{}] is invalid.");
            return "login";
        }
        request.getSession().setAttribute(WebConstants.WEB_LOGIN_USER, rouge);
        return "welcome";
    }

}
