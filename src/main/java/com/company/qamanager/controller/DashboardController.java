package com.company.qamanager.controller;

import com.company.qamanager.dto.DefectMetrics;
import com.company.qamanager.dto.DashboardMetrics;
import com.company.qamanager.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        DashboardMetrics metrics = dashboardService.getMetrics();
        DefectMetrics defectMetrics = dashboardService.getDefectMetrics();

        model.addAttribute("metrics", metrics);
        model.addAttribute("defectMetrics", defectMetrics);

        return "dashboard";
    }
}