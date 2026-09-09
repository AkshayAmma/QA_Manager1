package com.company.qamanager.controller;

import com.company.qamanager.entity.UserStory;
import com.company.qamanager.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stories")
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @GetMapping
    public String showStories(Model model) {

        model.addAttribute(
                "story",
                new UserStory()
        );

        model.addAttribute(
                "stories",
                service.findAll()
        );

        return "stories";
    }

    @PostMapping("/save")
    public String saveStory(
            @ModelAttribute("story") UserStory story) {

        service.save(story);

        return "redirect:/stories";
    }
}