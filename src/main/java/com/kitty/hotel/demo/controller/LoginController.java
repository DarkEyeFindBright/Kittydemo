package com.kitty.hotel.demo.controller;

import com.kitty.hotel.demo.entity.Login;
import com.kitty.hotel.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping(path = "/loginpage")
public class LoginController {

    @Resource
    private LoginService loginService;


    @PostMapping(path = "/test")
    public String login(Login login, Model model, HttpSession session) throws NoSuchAlgorithmException{
        System.out.println("" + login);
        Integer param = this.loginService.login(login);
        if (param==1) {
            session.setAttribute("id", login.getManageId());
            return "redirect:/manage";
        }

        return "redirect:/login";
    }

}
