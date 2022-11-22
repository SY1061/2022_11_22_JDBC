package com.nhnacademy.edu.jdbc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession(false);

        if(Objects.nonNull(session)){
            for(Cookie cookie : cookies){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
            session.invalidate();
        }

        return "/login";
    }
}
