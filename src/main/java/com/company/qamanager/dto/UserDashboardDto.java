package com.company.qamanager.dto;

public class UserDashboardDto {

    private long totalTasks;

    private long completedTasks;

    private long pendingTasks;

    private long totalDefects;

    private double totalHours;

    private int executedCases;

    private long assignedStories;

    private double productivity;

    public long getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(long totalTasks) {
        this.totalTasks = totalTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(long completedTasks) {
        this.completedTasks = completedTasks;
    }

    public long getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(long pendingTasks) {
        this.pendingTasks = pendingTasks;
    }

    public long getTotalDefects() {
        return totalDefects;
    }

    public void setTotalDefects(long totalDefects) {
        this.totalDefects = totalDefects;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public int getExecutedCases() {
        return executedCases;
    }

    public void setExecutedCases(int executedCases) {
        this.executedCases = executedCases;
    }

    public long getAssignedStories() {
        return assignedStories;
    }

    public void setAssignedStories(long assignedStories) {
        this.assignedStories = assignedStories;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }
}