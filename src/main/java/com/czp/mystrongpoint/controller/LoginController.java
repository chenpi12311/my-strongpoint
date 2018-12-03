package com.czp.mystrongpoint.controller;

import com.czp.mystrongpoint.constant.WebConstants;
import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.service.RougeService;
import com.czp.mystrongpoint.utils.MD5Utils;
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
                || !Objects.equals(rouge.getPassword(), MD5Utils.encode(password))) {
            logger.warn("This rouge [{}] is invalid.");
            return "login";
        }
        request.getSession().setAttribute(WebConstants.WEB_LOGIN_USER, rouge);
        return "welcome";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        if (!Objects.isNull(request.getSession().getAttribute(WebConstants.WEB_LOGIN_USER))) {
            Rouge rouge = (Rouge) request.getSession().getAttribute(WebConstants.WEB_LOGIN_USER);
            logger.info("The rouge [{}] logout.", rouge.getEmail());
        }
        request.getSession().removeAttribute(WebConstants.WEB_LOGIN_USER);
        return "login";
    }

}
