package com.company.qamanager.controller;

import com.company.qamanager.service.ExecutiveDashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/executive")
public class ExecutiveDashboardController {

    private final ExecutiveDashboardService service;

    public ExecutiveDashboardController(
            ExecutiveDashboardService service){

        this.service = service;
    }

    @GetMapping
    public String dashboard(
            Model model){

        model.addAttribute(
                "executive",
                service.getExecutiveSummary());

        model.addAttribute(
                "metrics",
                service.getMetrics());

        model.addAttribute(
                "defectMetrics",
                service.getDefectMetrics());

        model.addAttribute(
                "agileMetrics",
                service.getAgileMetrics());

        model.addAttribute(
                "release",
                service.getReleaseReadiness());

        model.addAttribute(
                "advanced",
                service.getAdvancedMetrics());

        model.addAttribute(
                "severity",
                service.getSeverityMetrics());

        model.addAttribute(
                "aging",
                service.getDefectAging());

        return "executive-dashboard";
    }
}