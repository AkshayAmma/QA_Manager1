package com.company.qamanager.controller;

import com.company.qamanager.entity.User;
import com.company.qamanager.service.DashboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final DashboardService dashboardService;

    public AdminController(DashboardService dashboardService)
    {
        this.dashboardService=dashboardService;
    }

    @GetMapping("/admin")
    public String adminDashboard(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser"
                );

        if(user == null) {
            return "redirect:/";
        }

        model.addAttribute(
                "user",
                user
        );

        model.addAttribute(
                "metrics",
                dashboardService.getMetrics()
        );

        model.addAttribute(
                "defectMetrics",
                dashboardService.getDefectMetrics()
        );

        return "admin-dashboard";
    }

//    @GetMapping("/stories")
//    public String stories(){
//
//        return "stories";
//    }

    @GetMapping("/tasks-page")
    public String tasks(){

        return "tasks";
    }

}