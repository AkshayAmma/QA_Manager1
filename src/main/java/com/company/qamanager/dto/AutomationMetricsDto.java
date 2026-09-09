package com.company.qamanager.dto;

public class AutomationMetricsDto {

    private double automationCoverage;
    private double apiAutomationCoverage;
    private double passRate;
    private double failureRate;
    private double automationLeverage;

    public double getAutomationCoverage() {
        return automationCoverage;
    }

    public void setAutomationCoverage(double automationCoverage) {
        this.automationCoverage = automationCoverage;
    }

    public double getApiAutomationCoverage() {
        return apiAutomationCoverage;
    }

    public void setApiAutomationCoverage(double apiAutomationCoverage) {
        this.apiAutomationCoverage = apiAutomationCoverage;
    }

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }

    public double getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(double failureRate) {
        this.failureRate = failureRate;
    }

    public double getAutomationLeverage() {
        return automationLeverage;
    }

    public void setAutomationLeverage(double automationLeverage) {
        this.automationLeverage = automationLeverage;
    }
}