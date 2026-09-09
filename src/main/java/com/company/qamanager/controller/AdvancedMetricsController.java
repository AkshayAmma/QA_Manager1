package com.company.qamanager.controller;

import com.company.qamanager.service.AdvancedMetricsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdvancedMetricsController {

    private final AdvancedMetricsService service;

    public AdvancedMetricsController(
            AdvancedMetricsService service) {

        this.service = service;
    }

    @GetMapping("/advanced-metrics")
    public String metrics(
            Model model){

        model.addAttribute(
                "advanced",
                service.getMetrics());

        return "advanced-metrics";
    }
}