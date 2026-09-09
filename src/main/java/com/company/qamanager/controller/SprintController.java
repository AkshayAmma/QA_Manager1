package com.company.qamanager.controller;

import com.company.qamanager.entity.Sprint;
import com.company.qamanager.service.DashboardService;
import com.company.qamanager.service.SnapshotService;
import com.company.qamanager.service.SprintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sprints")
public class SprintController {

    private final SprintService sprintService;
    private final DashboardService dashboardService;
    private final SnapshotService snapshotService;

    public SprintController(
            SprintService sprintService,
            DashboardService dashboardService,
            SnapshotService snapshotService) {

        this.sprintService = sprintService;
        this.dashboardService = dashboardService;
        this.snapshotService=snapshotService;
    }

    @GetMapping
    public String sprintPage(Model model){

        model.addAttribute(
                "sprint",
                new Sprint());

        model.addAttribute(
                "sprints",
                sprintService.findAll());

        model.addAttribute(
                "agileMetrics",
                dashboardService.getAgileMetrics());

        return "sprints";
    }

    @PostMapping("/save")
    public String saveSprint(
            @ModelAttribute Sprint sprint){

        sprintService.save(sprint);
        snapshotService.saveSnapshot(sprint.getSprintName());

        return "redirect:/sprints";
    }
}