package com.company.qamanager.controller;

import com.company.qamanager.entity.User;
import com.company.qamanager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    private final UserService userService;

    public SettingsController(UserService userService)
    {
        this.userService=userService;
    }


    @GetMapping("/settings")
    public String settings(
            HttpSession session,
            Model model) {

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        model.addAttribute(
                "user",
                user);

        return "settings";
    }

    @PostMapping("/update")
    public String updateSettings(
@ModelAttribute User user) {
        userService.updateUser(user);

        return "redirect:/settings";

    }
}