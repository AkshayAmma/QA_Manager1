package com.company.qamanager.dto;

public class ReportSummaryDto {

    private long totalEmployees;
    private int totalExecutedCases;
    private int totalDefects;
    private double coverage;
    private double automationCoverage;

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getTotalExecutedCases() {
        return totalExecutedCases;
    }

    public void setTotalExecutedCases(int totalExecutedCases) {
        this.totalExecutedCases = totalExecutedCases;
    }

    public int getTotalDefects() {
        return totalDefects;
    }

    public void setTotalDefects(int totalDefects) {
        this.totalDefects = totalDefects;
    }

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
}