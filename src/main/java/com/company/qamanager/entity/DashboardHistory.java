package com.company.qamanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dashboard_history")
public class DashboardHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sprintName;

    private Double coverage;

    private Double automationCoverage;

    private Integer defects;

    private Integer velocity;
    private String releaseStatus;

    private LocalDate createdDate;

    public DashboardHistory() {
    }

    public Long getId() {
        return id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Double getCoverage() {
        return coverage;
    }

    public void setCoverage(Double coverage) {
        this.coverage = coverage;
    }

    public Double getAutomationCoverage() {
        return automationCoverage;
    }

    public void setAutomationCoverage(Double automationCoverage) {
        this.automationCoverage = automationCoverage;
    }

    public Integer getDefects() {
        return defects;
    }

    public void setDefects(Integer defects) {
        this.defects = defects;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }
}