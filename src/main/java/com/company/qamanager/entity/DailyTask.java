package com.company.qamanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_tasks")
public class DailyTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String storyId;

    private Double hoursWorked;

    private Integer testCasesDesigned;

    private Integer testCasesExecuted;

    private Integer passedCount;

    private Integer failedCount;

    private Integer blockedCount;

    private Integer defectsRaised;

    private String remarks;

    private LocalDate taskDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Integer getTestCasesDesigned() {
        return testCasesDesigned;
    }

    public void setTestCasesDesigned(Integer testCasesDesigned) {
        this.testCasesDesigned = testCasesDesigned;
    }

    public Integer getTestCasesExecuted() {
        return testCasesExecuted;
    }

    public void setTestCasesExecuted(Integer testCasesExecuted) {
        this.testCasesExecuted = testCasesExecuted;
    }

    public Integer getPassedCount() {
        return passedCount;
    }

    public void setPassedCount(Integer passedCount) {
        this.passedCount = passedCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public Integer getBlockedCount() {
        return blockedCount;
    }

    public void setBlockedCount(Integer blockedCount) {
        this.blockedCount = blockedCount;
    }

    public Integer getDefectsRaised() {
        return defectsRaised;
    }

    public void setDefectsRaised(Integer defectsRaised) {
        this.defectsRaised = defectsRaised;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }
}