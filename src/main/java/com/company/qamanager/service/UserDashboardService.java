package com.company.qamanager.service;

import com.company.qamanager.dto.UserDashboardDto;
import com.company.qamanager.repository.DailyTaskRepository;
import com.company.qamanager.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDashboardService {

    private final DailyTaskRepository taskRepository;
    private final UserStoryRepository storyRepository;

    public UserDashboardService(
            DailyTaskRepository taskRepository,
            UserStoryRepository storyRepository) {

        this.taskRepository = taskRepository;
        this.storyRepository = storyRepository;
    }

    public UserDashboardDto getDashboard() {

        UserDashboardDto dto =
                new UserDashboardDto();

        dto.setTotalTasks(
                taskRepository.totalTasks());

        dto.setCompletedTasks(
                taskRepository.totalTasks());

        dto.setPendingTasks(
                0);

        dto.setTotalHours(
                taskRepository.totalHours());

        dto.setExecutedCases(
                taskRepository.executedCases());

        dto.setTotalDefects(
                taskRepository.totalRaisedDefects());

        dto.setAssignedStories(
                storyRepository.totalStories());

        double productivity = 0;

        if(dto.getTotalTasks() > 0){

            productivity =
                    dto.getCompletedTasks()*100.0
                            / dto.getTotalTasks();
        }

        dto.setProductivity(
                productivity);

        return dto;
    }
}