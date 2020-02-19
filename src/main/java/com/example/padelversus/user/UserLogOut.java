package com.example.padelversus.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserLogOut {

    @RequestMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!username.equals("anonymousUser")) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
            return "logout";
        }
        return "index";
    }
}
