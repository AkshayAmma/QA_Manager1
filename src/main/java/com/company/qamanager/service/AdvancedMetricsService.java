package com.company.qamanager.service;

import com.company.qamanager.dto.AdvancedMetricsDto;
import com.company.qamanager.repository.AutomationMetricRepository;
import com.company.qamanager.repository.DefectRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvancedMetricsService {

    private final AutomationMetricRepository automationRepo;

    private final DefectRepository defectRepo;

    public AdvancedMetricsService(
            AutomationMetricRepository automationRepo,
            DefectRepository defectRepo) {

        this.automationRepo = automationRepo;
        this.defectRepo = defectRepo;
    }

    public AdvancedMetricsDto getMetrics() {

        AdvancedMetricsDto dto =
                new AdvancedMetricsDto();

        Integer passedCases =
                automationRepo.totalPassedCases();

        Integer executedScripts =
                automationRepo.executedScripts();

        double fpr = 0;

        if(executedScripts != null &&
                executedScripts > 0){

            fpr =
                    passedCases * 100.0
                            / executedScripts;
        }

        long productionDefects =
                defectRepo.productionDefects();

        long totalDefects =
                defectRepo.allDefects();

        double escapeRate = 0;

        if(totalDefects > 0){

            escapeRate =
                    productionDefects *100.0
                            / totalDefects;
        }

        long closed =
                defectRepo.closedDefects();

        long closedWithoutReopen =
                defectRepo.closedWithoutReopen();

        double qualityOfFix = 0;

        if(closed > 0){

            qualityOfFix =
                    closedWithoutReopen *100.0
                            / closed;
        }

        dto.setFirstPassRate(fpr);

        dto.setDefectEscapeRate(
                escapeRate);

        dto.setQualityOfFix(
                qualityOfFix);

        dto.setCriticalOpen(
                defectRepo.criticalOpen());

        dto.setHighOpen(
                defectRepo.highOpen());

        dto.setMediumOpen(
                defectRepo.mediumOpen());

        dto.setLowOpen(
                defectRepo.lowOpen());

        return dto;
    }
}