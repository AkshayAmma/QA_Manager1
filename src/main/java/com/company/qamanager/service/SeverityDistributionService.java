package com.company.qamanager.service;

import com.company.qamanager.dto.SeverityMetricsDto;
import com.company.qamanager.repository.DefectRepository;
import org.springframework.stereotype.Service;

@Service
public class SeverityDistributionService {

    private final DefectRepository repository;

    public SeverityDistributionService(
            DefectRepository repository) {

        this.repository = repository;
    }

    public SeverityMetricsDto getSeverityMetrics() {

        SeverityMetricsDto dto =
                new SeverityMetricsDto();

        dto.setCritical(
                repository.criticalCount());

        dto.setHigh(
                repository.highCount());

        dto.setMedium(
                repository.mediumCount());

        dto.setLow(
                repository.lowCount());

        return dto;
    }
}