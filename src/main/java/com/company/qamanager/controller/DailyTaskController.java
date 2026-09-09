package com.company.qamanager.controller;

import com.company.qamanager.entity.DailyTask;
import com.company.qamanager.service.DailyTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class DailyTaskController {

    private final DailyTaskService service;

    public DailyTaskController(
            DailyTaskService service) {

        this.service = service;
    }

    @GetMapping
    public String taskPage(
            Model model) {

        model.addAttribute(
                "task",
                new DailyTask());

        model.addAttribute(
                "tasks",
                service.findAll());

        return "tasks";
    }

    @PostMapping("/save")
    public String saveTask(
            @ModelAttribute DailyTask task) {

        service.save(task);

        return "redirect:/tasks";
    }
}