package com.company.qamanager.controller;

import com.company.qamanager.repository.DailyTaskRepository;
import com.company.qamanager.service.ReportService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final DailyTaskRepository taskRepository;
    private final ReportService reportService;



    public ReportController(
            DailyTaskRepository taskRepository,
            ReportService reportService) {

        this.taskRepository = taskRepository;
        this.reportService=reportService;
    }

    @GetMapping
    public String reports(Model model) {

        model.addAttribute(
                "tasks",
                taskRepository.findAll()
        );

        model.addAttribute("report",reportService.getSummary());

        return "reports";
    }



}