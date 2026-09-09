package com.company.qamanager.service;

import com.company.qamanager.dto.AnalyticsDto;
import com.company.qamanager.entity.DashboardHistory;
import com.company.qamanager.repository.DashboardHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    private final DashboardHistoryRepository repository;

    public AnalyticsService(
            DashboardHistoryRepository repository) {

        this.repository = repository;
    }

    public AnalyticsDto getAnalytics() {

        List<DashboardHistory> history =
                repository.findAllByOrderByCreatedDateAsc();

        AnalyticsDto dto =
                new AnalyticsDto();

        List<String> sprints =
                new ArrayList<>();

        List<Double> coverages =
                new ArrayList<>();

        List<Double> automation =
                new ArrayList<>();

        List<Integer> defects =
                new ArrayList<>();

        List<Integer> velocity =
                new ArrayList<>();

        for(DashboardHistory h : history){

            sprints.add(
                    h.getSprintName());

            coverages.add(
                    h.getCoverage());

            automation.add(
                    h.getAutomationCoverage());

            defects.add(
                    h.getDefects());

            velocity.add(
                    h.getVelocity());
        }

        dto.setSprintNames(sprints);
        dto.setCoverages(coverages);
        dto.setAutomationCoverages(automation);
        dto.setDefects(defects);
        dto.setVelocities(velocity);

        return dto;
    }
}