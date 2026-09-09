package com.company.qamanager.service;

import com.company.qamanager.dto.AgileMetricsDto;
import com.company.qamanager.dto.DashboardMetrics;
import com.company.qamanager.dto.ReleaseReadinessDto;
import com.company.qamanager.entity.DashboardHistory;
import com.company.qamanager.repository.DashboardHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SnapshotService {

    private final DashboardHistoryRepository repository;

    private final DashboardService dashboardService;

    private final ReleaseReadinessService releaseService;

    public SnapshotService(
            DashboardHistoryRepository repository,
            DashboardService dashboardService,
            ReleaseReadinessService releaseService) {

        this.repository = repository;
        this.dashboardService = dashboardService;
        this.releaseService = releaseService;
    }

    public void saveSnapshot(
            String sprintName) {

        DashboardMetrics dashboardMetrics =
                dashboardService.getMetrics();

        AgileMetricsDto agileMetrics =
                dashboardService.getAgileMetrics();

        ReleaseReadinessDto release =
                releaseService.getReleaseReadiness();

        DashboardHistory history =
                new DashboardHistory();

        history.setSprintName(
                sprintName);

        history.setCoverage(
                dashboardMetrics
                        .getCoveragePercentage());

        history.setAutomationCoverage(
                release
                        .getAutomationCoverage());

        history.setDefects(
                dashboardMetrics
                        .getTotalDefects());

        history.setVelocity(
                (int) agileMetrics
                        .getVelocity());

        history.setReleaseStatus(
                release.getReleaseStatus());

        history.setCreatedDate(
                LocalDate.now());

        repository.save(history);
    }
}