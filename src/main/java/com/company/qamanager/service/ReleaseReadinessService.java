package com.company.qamanager.service;

import com.company.qamanager.dto.DashboardMetrics;
import com.company.qamanager.dto.ReleaseReadinessDto;
import com.company.qamanager.repository.DefectRepository;
import org.springframework.stereotype.Service;

@Service
public class ReleaseReadinessService {

    private final DashboardService dashboardService;
    private final DefectRepository defectRepository;
    private final AutomationMetricsService automationMetricsService;
    public ReleaseReadinessService(
            DashboardService dashboardService,
            DefectRepository defectRepository,
            AutomationMetricsService automationMetricsService) {

        this.dashboardService = dashboardService;
        this.defectRepository = defectRepository;
        this.automationMetricsService=automationMetricsService;
    }

    public ReleaseReadinessDto getReleaseReadiness() {

        ReleaseReadinessDto dto =
                new ReleaseReadinessDto();

        DashboardMetrics metrics =
                dashboardService.getMetrics();

        double coverage =
                metrics.getCoveragePercentage();

        long criticalDefects =
                defectRepository.criticalDefects();

        long prodLeakage =
                defectRepository.productionLeakageCount();

        double automationCoverage = automationMetricsService.getAutomationCoverage();

        dto.setCoverage(coverage);

        dto.setAutomationCoverage(
                automationCoverage);

        dto.setCriticalDefects(
                criticalDefects);

        dto.setProductionLeakage(
                prodLeakage);

        String status;

        if(coverage >= 90
                && automationCoverage >= 70
                && criticalDefects == 0
                && prodLeakage < 5){

            status = "READY";
        }
        else{

            status = "NOT READY";
        }

        dto.setReleaseStatus(status);

        return dto;
    }
}