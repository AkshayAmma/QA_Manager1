package com.company.qamanager.service;

import com.company.qamanager.dto.*;
import org.springframework.stereotype.Service;

@Service
public class ExecutiveDashboardService {

    private final DashboardService dashboardService;
    private final ReleaseReadinessService releaseReadinessService;
    private final SeverityDistributionService severityService;
    private final DefectAgingService defectAgingService;
    private final AdvancedMetricsService advancedMetricsService;

    public ExecutiveDashboardService(
            DashboardService dashboardService,
            ReleaseReadinessService releaseReadinessService,
            SeverityDistributionService severityService,
            DefectAgingService defectAgingService,
            AdvancedMetricsService advancedMetricsService) {

        this.dashboardService = dashboardService;
        this.releaseReadinessService = releaseReadinessService;
        this.severityService = severityService;
        this.defectAgingService = defectAgingService;
        this.advancedMetricsService = advancedMetricsService;
    }

    public ExecutiveDashboardDto getExecutiveSummary() {

        ExecutiveDashboardDto dto =
                new ExecutiveDashboardDto();

        DashboardMetrics dashboardMetrics =
                dashboardService.getMetrics();

        DefectMetrics defectMetrics =
                dashboardService.getDefectMetrics();

        AgileMetricsDto agileMetrics =
                dashboardService.getAgileMetrics();

        ReleaseReadinessDto release =
                releaseReadinessService.getReleaseReadiness();

        dto.setCoverage(
                dashboardMetrics.getCoveragePercentage());

        dto.setAutomationCoverage(
                release.getAutomationCoverage());

        dto.setVelocity(
                agileMetrics.getVelocity());

        dto.setCriticalDefects(
                release.getCriticalDefects());

        dto.setDefectDensity(
                defectMetrics.getDefectDensity());

        dto.setReleaseStatus(
                release.getReleaseStatus());


        String healthStatus;

        if (dto.getCoverage() >= 90
                && dto.getAutomationCoverage() >= 70
                && dto.getCriticalDefects() == 0) {

            healthStatus = "GREEN";
        }
        else if (dto.getCoverage() >= 75
                && dto.getAutomationCoverage() >= 50) {

            healthStatus = "AMBER";
        }
        else {

            healthStatus = "RED";
        }

        dto.setHealthStatus(
                healthStatus);

        return dto;
    }

    public DashboardMetrics getMetrics() {

        return dashboardService.getMetrics();
    }

    public DefectMetrics getDefectMetrics() {

        return dashboardService.getDefectMetrics();
    }

    public AgileMetricsDto getAgileMetrics() {

        return dashboardService.getAgileMetrics();
    }

    public ReleaseReadinessDto getReleaseReadiness() {

        return releaseReadinessService.getReleaseReadiness();
    }

    public AdvancedMetricsDto getAdvancedMetrics() {

        return advancedMetricsService.getMetrics();
    }

    public SeverityMetricsDto getSeverityMetrics() {

        return severityService.getSeverityMetrics();
    }

    public DefectAgingDto getDefectAging() {

        return defectAgingService.getDefectAging();
    }
}