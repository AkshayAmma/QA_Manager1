package com.company.qamanager.dto;

public class DashboardMetrics {

    private long totalEmployees;
    private long totalStories;
    private int totalTestCases;
    private int executedTestCases;
    private double coveragePercentage;
    private double totalHoursWorked;
    private int totalDefects;

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getTotalStories() {
        return totalStories;
    }

    public void setTotalStories(long totalStories) {
        this.totalStories = totalStories;
    }

    public int getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(int totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public int getExecutedTestCases() {
        return executedTestCases;
    }

    public void setExecutedTestCases(int executedTestCases) {
        this.executedTestCases = executedTestCases;
    }

    public double getCoveragePercentage() {
        return coveragePercentage;
    }

    public void setCoveragePercentage(double coveragePercentage) {
        this.coveragePercentage = coveragePercentage;
    }

    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(double totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public int getTotalDefects() {
        return totalDefects;
    }

    public void setTotalDefects(int totalDefects) {
        this.totalDefects = totalDefects;
    }
}