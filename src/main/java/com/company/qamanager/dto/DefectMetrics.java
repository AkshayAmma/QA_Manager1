package com.company.qamanager.dto;

public class DefectMetrics {

    private double defectDensity;
    private double rejectionRate;
    private double reopenRate;
    private double uatLeakageRate;
    private double productionLeakageRate;

    // getters setters

    public double getDefectDensity() {
        return defectDensity;
    }

    public void setDefectDensity(double defectDensity) {
        this.defectDensity = defectDensity;
    }

    public double getRejectionRate() {
        return rejectionRate;
    }

    public void setRejectionRate(double rejectionRate) {
        this.rejectionRate = rejectionRate;
    }

    public double getReopenRate() {
        return reopenRate;
    }

    public void setReopenRate(double reopenRate) {
        this.reopenRate = reopenRate;
    }

    public double getUatLeakageRate() {
        return uatLeakageRate;
    }

    public void setUatLeakageRate(double uatLeakageRate) {
        this.uatLeakageRate = uatLeakageRate;
    }

    public double getProductionLeakageRate() {
        return productionLeakageRate;
    }

    public void setProductionLeakageRate(double productionLeakageRate) {
        this.productionLeakageRate = productionLeakageRate;
    }
}