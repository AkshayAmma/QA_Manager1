package com.company.qamanager.controller;

import com.company.qamanager.service.SeverityDistributionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeverityController {

    private final SeverityDistributionService service;

    public SeverityController(
            SeverityDistributionService service) {

        this.service = service;
    }

    @GetMapping("/severity")
    public String severityPage(Model model){

        model.addAttribute(
                "severity",
                service.getSeverityMetrics());

        return "severity";
    }
}