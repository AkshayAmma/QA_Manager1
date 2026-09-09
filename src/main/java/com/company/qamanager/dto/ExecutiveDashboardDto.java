package com.company.qamanager.dto;

public class ExecutiveDashboardDto {

    private double coverage;

    private double automationCoverage;

    private double velocity;

    private long criticalDefects;

    private double defectDensity;

    private String releaseStatus;

    private String healthStatus;

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public double getAutomationCoverage() {
        return automationCoverage;
    }

    public void setAutomationCoverage(double automationCoverage) {
        this.automationCoverage = automationCoverage;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public long getCriticalDefects() {
        return criticalDefects;
    }

    public void setCriticalDefects(long criticalDefects) {
        this.criticalDefects = criticalDefects;
    }

    public double getDefectDensity() {
        return defectDensity;
    }

    public void setDefectDensity(double defectDensity) {
        this.defectDensity = defectDensity;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}