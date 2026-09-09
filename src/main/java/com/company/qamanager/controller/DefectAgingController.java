package com.company.qamanager.controller;

import com.company.qamanager.service.DefectAgingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefectAgingController {

    private final DefectAgingService service;

    public DefectAgingController(
            DefectAgingService service) {

        this.service = service;
    }

    @GetMapping("/defect-aging")
    public String defectAging(
            Model model) {

        model.addAttribute(
                "aging",
                service.getDefectAging());

        return "defect-aging";
    }
}