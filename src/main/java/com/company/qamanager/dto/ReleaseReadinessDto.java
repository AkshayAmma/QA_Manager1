package com.company.qamanager.dto;

public class ReleaseReadinessDto {

    private double coverage;
    private double automationCoverage;
    private long criticalDefects;
    private double productionLeakage;
    private String releaseStatus;

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

    public long getCriticalDefects() {
        return criticalDefects;
    }

    public void setCriticalDefects(long criticalDefects) {
        this.criticalDefects = criticalDefects;
    }

    public double getProductionLeakage() {
        return productionLeakage;
    }

    public void setProductionLeakage(double productionLeakage) {
        this.productionLeakage = productionLeakage;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }
}