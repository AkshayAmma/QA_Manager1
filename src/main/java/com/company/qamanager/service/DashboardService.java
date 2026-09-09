package com.company.qamanager.service;

import com.company.qamanager.dto.AgileMetricsDto;
import com.company.qamanager.dto.DashboardMetrics;
import com.company.qamanager.dto.DefectMetrics;
import com.company.qamanager.entity.Sprint;
import com.company.qamanager.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final EmployeeRepository employeeRepository;
    private final UserStoryRepository storyRepository;
    private final DailyTaskRepository taskRepository;
    private final DefectRepository defectRepository;
    private final SprintRepository sprintRepository;

    public DashboardService(
            EmployeeRepository employeeRepository,
            UserStoryRepository storyRepository,
            DailyTaskRepository taskRepository,
            DefectRepository defectRepository,
            SprintRepository sprintRepository) {

        this.employeeRepository = employeeRepository;
        this.storyRepository = storyRepository;
        this.taskRepository = taskRepository;
        this.defectRepository = defectRepository;
        this.sprintRepository=sprintRepository;
    }

    public DashboardMetrics getMetrics() {

        DashboardMetrics metrics =
                new DashboardMetrics();

        metrics.setTotalEmployees(
                employeeRepository.count());

        metrics.setTotalStories(
                storyRepository.count());

        Integer totalCases =
                storyRepository.getTotalTestCases();

        Integer executedCases =
                taskRepository.getTotalExecutedCases();

        Double totalHours =
                taskRepository.getTotalHours();

        Integer defects =
                taskRepository.getTotalDefects();

        metrics.setTotalTestCases(
                totalCases == null ? 0 : totalCases);

        metrics.setExecutedTestCases(
                executedCases == null ? 0 : executedCases);

        metrics.setTotalHoursWorked(
                totalHours == null ? 0.0 : totalHours);

        metrics.setTotalDefects(
                defects == null ? 0 : defects);

        double coverage = 0;

        if (totalCases != null &&
                totalCases > 0 &&
                executedCases != null) {

            coverage =
                    (executedCases * 100.0)
                            / totalCases;
        }

        metrics.setCoveragePercentage(
                coverage);

        return metrics;
    }

    public DefectMetrics getDefectMetrics() {

        DefectMetrics metrics =
                new DefectMetrics();

        long totalDefects =
                defectRepository.totalDefects();

        long rejectedDefects =
                defectRepository.rejectedDefects();

        long reopenedDefects =
                defectRepository.reopenedDefects();

        long uatLeakage =
                defectRepository.uatLeakageDefects();

        long productionLeakage =
                defectRepository.productionLeakageDefects();

        long totalStories =
                storyRepository.count();

        double defectDensity = 0;

        if (totalStories > 0) {

            defectDensity =
                    (double) totalDefects
                            / totalStories;
        }

        double rejectionRate = 0;

        if (totalDefects > 0) {

            rejectionRate =
                    ((double) rejectedDefects * 100)
                            / totalDefects;
        }

        double reopenRate = 0;

        if (totalDefects > 0) {

            reopenRate =
                    ((double) reopenedDefects * 100)
                            / totalDefects;
        }

        double uatRate = 0;

        if (totalDefects > 0) {

            uatRate =
                    ((double) uatLeakage * 100)
                            / totalDefects;
        }

        double productionRate = 0;

        if (totalDefects > 0) {

            productionRate =
                    ((double) productionLeakage * 100)
                            / totalDefects;
        }

        metrics.setDefectDensity(
                defectDensity);

        metrics.setRejectionRate(
                rejectionRate);

        metrics.setReopenRate(
                reopenRate);

        metrics.setUatLeakageRate(
                uatRate);

        metrics.setProductionLeakageRate(
                productionRate);

        return metrics;
    }

    public AgileMetricsDto getAgileMetrics() {

        AgileMetricsDto dto =
                new AgileMetricsDto();

        List<Sprint> sprints =
                sprintRepository.findAll();

        if(sprints.isEmpty()) {
            return dto;
        }

        Sprint sprint =
                sprints.get(sprints.size()-1);

        double velocity =
                sprint.getCompletedStoryPoints();

        dto.setVelocity(velocity);

        if(sprint.getPlannedStoryPoints() > 0) {

            dto.setCommittedVsActual(
                    sprint.getCompletedStoryPoints()
                            *100.0
                            / sprint.getPlannedStoryPoints());
        }

        if(sprint.getFinalRequirements() > 0) {

            dto.setRequirementStabilityIndex(
                    sprint.getInitialRequirements()
                            *100.0
                            / sprint.getFinalRequirements());
        }

        if(sprint.getPlannedStories() > 0) {

            dto.setOnTimeDelivery(
                    sprint.getCompletedStories()
                            *100.0
                            / sprint.getPlannedStories());
        }

        return dto;
    }
}