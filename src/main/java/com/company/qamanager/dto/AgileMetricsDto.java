package com.company.qamanager.dto;

public class AgileMetricsDto {

    private double velocity;

    private double committedVsActual;

    private double requirementStabilityIndex;

    private double onTimeDelivery;

    private double firstPassRate;

    private double errorDiscoveryRate;

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getCommittedVsActual() {
        return committedVsActual;
    }

    public void setCommittedVsActual(double committedVsActual) {
        this.committedVsActual = committedVsActual;
    }

    public double getRequirementStabilityIndex() {
        return requirementStabilityIndex;
    }

    public void setRequirementStabilityIndex(double requirementStabilityIndex) {
        this.requirementStabilityIndex = requirementStabilityIndex;
    }

    public double getOnTimeDelivery() {
        return onTimeDelivery;
    }

    public void setOnTimeDelivery(double onTimeDelivery) {
        this.onTimeDelivery = onTimeDelivery;
    }

    public double getFirstPassRate() {
        return firstPassRate;
    }

    public void setFirstPassRate(double firstPassRate) {
        this.firstPassRate = firstPassRate;
    }

    public double getErrorDiscoveryRate() {
        return errorDiscoveryRate;
    }

    public void setErrorDiscoveryRate(double errorDiscoveryRate) {
        this.errorDiscoveryRate = errorDiscoveryRate;
    }
}