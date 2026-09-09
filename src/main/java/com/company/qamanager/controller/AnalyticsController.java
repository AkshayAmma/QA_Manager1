package com.company.qamanager.controller;

import com.company.qamanager.service.AnalyticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(
            AnalyticsService analyticsService) {

        this.analyticsService = analyticsService;
    }

    @GetMapping("/analytics")
    public String analyticsPage(
            Model model){

        model.addAttribute(
                "analytics",
                analyticsService.getAnalytics());

        return "analytics";
    }
}