package com.genie.Ecomm.controller;

import com.genie.Ecomm.model.User;
import com.genie.Ecomm.service.userService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class login {
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        userService.UserService userService = null;
        User user = userService.validateUser(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            return "redirect:/login?error=true";
        }
    }

}
