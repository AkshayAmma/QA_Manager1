package com.company.qamanager.controller;

import com.company.qamanager.repository.DashboardHistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryController {

    private final DashboardHistoryRepository repository;

    public HistoryController(
            DashboardHistoryRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/history")
    public String historyPage(
            Model model){

        model.addAttribute(
                "history",
                repository.findAll());

        return "history";
    }
}