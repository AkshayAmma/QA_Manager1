package com.company.qamanager.controller;

import com.company.qamanager.dto.AutomationMetricsDto;
import com.company.qamanager.service.AutomationMetricsService;
import com.company.qamanager.service.AutomationMetricsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/automation")
public class AutomationController {

    private final AutomationMetricsService automationService;

    public AutomationController(AutomationMetricsService automationService) {
        this.automationService = automationService;
    }

    @GetMapping
    public String automationPage(Model model) {

        AutomationMetricsDto metrics =
                automationService.getAutomationMetrics();

        model.addAttribute(
                "automationMetrics",
                metrics);

        return "automation";
    }
}