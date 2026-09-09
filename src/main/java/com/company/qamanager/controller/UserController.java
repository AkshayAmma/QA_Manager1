package com.company.qamanager.controller;

import com.company.qamanager.entity.DailyTask;
import com.company.qamanager.entity.Defect;
import com.company.qamanager.entity.User;
import com.company.qamanager.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserDashboardService dashboardService;
    private  final DailyTaskService dailyTaskService;
    private final UserStoryService storyService;
    private final DefectService defectService;
    private final SprintService sprintService;

    public UserController(UserDashboardService dashboardService,DailyTaskService dailyTaskService,UserStoryService storyService,DefectService defectService,SprintService sprintService)
    {
        this.dashboardService=dashboardService;
        this.dailyTaskService=dailyTaskService;
        this.storyService=storyService;
        this.defectService=defectService;
        this.sprintService=sprintService;
    }

    @GetMapping("/user")
    public String userDashboard(
            HttpSession session,
            Model model) {

        System.out.println("User Controller Called");
        User user =
                (User) session.getAttribute("loggedInUser");

        System.out.println("User Session = " + user);

        if(user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);

        model.addAttribute("dashboard",dashboardService.getDashboard());

        return "user-dashboard";
    }

    @GetMapping("/user/tasks")
    public String myTasks(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        model.addAttribute(
                "tasks",
                dailyTaskService.findAll());

        model.addAttribute(
                "dashboard",
                dashboardService.getDashboard());

        model.addAttribute(
                "user",
                user);

        return "user-tasks";
    }

    @GetMapping("/user/task/new")
    public String taskForm(Model model){

        model.addAttribute(
                "task",
                new DailyTask());

        return "user-task-form";
    }

    @PostMapping("/user/task/save")
    public String saveTask(
            @ModelAttribute DailyTask task,
            HttpSession session) {

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        task.setEmployeeId(
                user.getId());

        dailyTaskService.save(task);

        return "redirect:/user/tasks";
    }

    @GetMapping("/user/defect/new")
    public String defectForm(
            Model model){

        model.addAttribute(
                "defect",
                new Defect());

        return "user-defect-form";
    }
    @PostMapping("/user/defect/save")
    public String saveDefect(
            @ModelAttribute Defect defect){

        defectService.save(defect);

        return "redirect:/user/defects";
    }

    @GetMapping("/user/stories")
    public String myStories(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        model.addAttribute(
                "stories",
                storyService.findAll());

        model.addAttribute(
                "user",
                user);

        return "user-stories";
    }
    @GetMapping("/user/defects")
    public String myDefects(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        var defects =
                defectService.findAll();

        long openCount =
                defects.stream()
                        .filter(d ->
                                "OPEN".equalsIgnoreCase(
                                        d.getStatus()))
                        .count();

        long closedCount =
                defects.stream()
                        .filter(d ->
                                "CLOSED".equalsIgnoreCase(
                                        d.getStatus()))
                        .count();

        model.addAttribute(
                "defects",
                defects);

        model.addAttribute(
                "openCount",
                openCount);

        model.addAttribute(
                "closedCount",
                closedCount);

        model.addAttribute(
                "user",
                user);

        return "user-defects";
    }

    @GetMapping("/user/sprints")
    public String mySprints(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        var sprints =
                sprintService.findAll();

        model.addAttribute(
                "sprints",
                sprints);

        model.addAttribute(
                "user",
                user);

        model.addAttribute(
                "totalSprints",
                sprints.size());

        return "user-sprints";
    }

    @GetMapping("/user/analytics")
    public String myAnalytics(
            HttpSession session,
            Model model){

        User user =
                (User) session.getAttribute(
                        "loggedInUser");

        model.addAttribute(
                "dashboard",
                dashboardService.getDashboard());

        model.addAttribute(
                "user",
                user);

        return "user-analytics";
    }
}