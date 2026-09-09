package com.company.qamanager.controller;

import com.company.qamanager.entity.Defect;
import com.company.qamanager.service.DefectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/defects")
public class DefectController {

    private final DefectService service;

    public DefectController(
            DefectService service) {

        this.service = service;
    }

    @GetMapping
    public String showPage(
            Model model){

        model.addAttribute(
                "defect",
                new Defect());

        model.addAttribute(
                "defects",
                service.findAll());

        return "defects";
    }

    @PostMapping("/save")
    public String saveDefect(
            @ModelAttribute Defect defect){

        service.save(defect);

        return "redirect:/defects";
    }
}