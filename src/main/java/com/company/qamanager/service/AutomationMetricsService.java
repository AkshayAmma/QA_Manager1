package com.company.qamanager.service;

import com.company.qamanager.dto.AutomationMetricsDto;
import com.company.qamanager.repository.AutomationMetricRepository;
import org.springframework.stereotype.Service;

@Service
public class AutomationMetricsService {
    public final AutomationMetricRepository automationMetricRepository;

    public AutomationMetricsService(AutomationMetricRepository automationMetricRepository)
    {
        this.automationMetricRepository=automationMetricRepository;
    }


    public AutomationMetricsDto getAutomationMetrics() {

        AutomationMetricsDto dto =
                new AutomationMetricsDto();

        Integer totalTC =
                automationMetricRepository.totalTestCases();

        Integer automatedTC =
                automationMetricRepository.automatedCases();

        Integer totalApis =
                automationMetricRepository.totalApis();

        Integer automatedApis =
                automationMetricRepository.automatedApis();

        Integer executed =
                automationMetricRepository.executedScripts();

        Integer passed =
                automationMetricRepository.passedScripts();

        Integer failed =
                automationMetricRepository.failedScripts();

        double coverage = 0;

        if (totalTC > 0) {
            coverage =
                    (automatedTC * 100.0)
                            / totalTC;
        }

        double apiCoverage = 0;

        if (totalApis > 0) {
            apiCoverage =
                    (automatedApis * 100.0)
                            / totalApis;
        }

        double passRate = 0;

        if (executed > 0) {
            passRate =
                    (passed * 100.0)
                            / executed;
        }

        double failureRate = 0;

        if (executed > 0) {
            failureRate =
                    (failed * 100.0)
                            / executed;
        }

        double leverage = coverage;

        dto.setAutomationCoverage(coverage);

        dto.setApiAutomationCoverage(apiCoverage);

        dto.setPassRate(passRate);

        dto.setFailureRate(failureRate);

        dto.setAutomationLeverage(leverage);

        return dto;
    }

    public double getAutomationCoverage() {

        Integer totalCases =

        automationMetricRepository.totalTestCases();

        Integer automatedCases =
        automationMetricRepository.automatedCases();

        if(totalCases == null

                || totalCases == 0) {

            return 0;

        }

        return (automatedCases * 100.0)
                / totalCases;
    }

}

