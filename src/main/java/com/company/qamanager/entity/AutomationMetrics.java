package com.company.qamanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "automation_metrics")
public class AutomationMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storyId;

    private String automationType;

    private Integer totalTestCases;

    private Integer automatedCases;

    private Integer totalApis;

    private Integer automatedApis;

    private Integer executedScripts;

    private Integer passedScripts;

    private Integer failedScripts;

    private LocalDate executionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getAutomationType() {
        return automationType;
    }

    public void setAutomationType(String automationType) {
        this.automationType = automationType;
    }

    public Integer getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(Integer totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public Integer getAutomatedCases() {
        return automatedCases;
    }

    public void setAutomatedCases(Integer automatedCases) {
        this.automatedCases = automatedCases;
    }

    public Integer getTotalApis() {
        return totalApis;
    }

    public void setTotalApis(Integer totalApis) {
        this.totalApis = totalApis;
    }

    public Integer getAutomatedApis() {
        return automatedApis;
    }

    public void setAutomatedApis(Integer automatedApis) {
        this.automatedApis = automatedApis;
    }

    public Integer getExecutedScripts() {
        return executedScripts;
    }

    public void setExecutedScripts(Integer executedScripts) {
        this.executedScripts = executedScripts;
    }

    public Integer getPassedScripts() {
        return passedScripts;
    }

    public void setPassedScripts(Integer passedScripts) {
        this.passedScripts = passedScripts;
    }

    public Integer getFailedScripts() {
        return failedScripts;
    }

    public void setFailedScripts(Integer failedScripts) {
        this.failedScripts = failedScripts;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }
}