package com.company.qamanager.controller;

import com.company.qamanager.entity.User;
import com.company.qamanager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model, HttpSession session) {

        System.out.println("Email: " + email);

        User user = service.login(email, password);

        System.out.println("User: " + user);

        if (user == null) {
            model.addAttribute("error", "Invalid Credentials");
            return "login";
        }

        session.setAttribute("loggedInUser",user);

        System.out.println("Role: " + user.getRole());

        model.addAttribute("user", user);

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        }

        System.out.println("Redirecting USER");
        return "redirect:/user";
    }
}