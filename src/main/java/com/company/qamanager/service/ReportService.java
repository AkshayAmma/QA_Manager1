package com.company.qamanager.service;

import com.company.qamanager.dto.DashboardMetrics;
import com.company.qamanager.dto.ReportSummaryDto;
import com.company.qamanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final EmployeeRepository employeeRepository;
    private final DashboardService dashboardService;

    public ReportService(
            EmployeeRepository employeeRepository,
            DashboardService dashboardService) {

        this.employeeRepository = employeeRepository;
        this.dashboardService = dashboardService;
    }

    public ReportSummaryDto getSummary() {

        ReportSummaryDto dto =
                new ReportSummaryDto();

        DashboardMetrics metrics =
                dashboardService.getMetrics();

        dto.setTotalEmployees(
                employeeRepository.count());

        dto.setTotalExecutedCases(
                metrics.getExecutedTestCases());

        dto.setTotalDefects(
                metrics.getTotalDefects());

        dto.setCoverage(
                metrics.getCoveragePercentage());

        return dto;
    }
}

