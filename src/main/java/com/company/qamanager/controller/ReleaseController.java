package com.company.qamanager.controller;

import com.company.qamanager.service.ReleaseReadinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReleaseController {

    private final ReleaseReadinessService service;

    public ReleaseController(
            ReleaseReadinessService service) {

        this.service = service;
    }

    @GetMapping("/release")
    public String releasePage(
            Model model){

        model.addAttribute(
                "release",
                service.getReleaseReadiness()
        );

        return "release-readiness";
    }
}