package com.company.qamanager.dto;

import java.util.List;

public class AnalyticsDto {

    private List<String> sprintNames;

    private List<Double> coverages;

    private List<Double> automationCoverages;

    private List<Integer> defects;

    private List<Integer> velocities;

    public List<String> getSprintNames() {
        return sprintNames;
    }

    public void setSprintNames(List<String> sprintNames) {
        this.sprintNames = sprintNames;
    }

    public List<Double> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Double> coverages) {
        this.coverages = coverages;
    }

    public List<Double> getAutomationCoverages() {
        return automationCoverages;
    }

    public void setAutomationCoverages(List<Double> automationCoverages) {
        this.automationCoverages = automationCoverages;
    }

    public List<Integer> getDefects() {
        return defects;
    }

    public void setDefects(List<Integer> defects) {
        this.defects = defects;
    }

    public List<Integer> getVelocities() {
        return velocities;
    }

    public void setVelocities(List<Integer> velocities) {
        this.velocities = velocities;
    }
}
