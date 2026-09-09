package com.company.qamanager.dto;

public class AdvancedMetricsDto {

    private double firstPassRate;

    private double defectEscapeRate;

    private double qualityOfFix;

    private long criticalOpen;

    private long highOpen;

    private long mediumOpen;

    private long lowOpen;

    public double getFirstPassRate() {
        return firstPassRate;
    }

    public void setFirstPassRate(double firstPassRate) {
        this.firstPassRate = firstPassRate;
    }

    public double getDefectEscapeRate() {
        return defectEscapeRate;
    }

    public void setDefectEscapeRate(double defectEscapeRate) {
        this.defectEscapeRate = defectEscapeRate;
    }

    public double getQualityOfFix() {
        return qualityOfFix;
    }

    public void setQualityOfFix(double qualityOfFix) {
        this.qualityOfFix = qualityOfFix;
    }

    public long getCriticalOpen() {
        return criticalOpen;
    }

    public void setCriticalOpen(long criticalOpen) {
        this.criticalOpen = criticalOpen;
    }

    public long getHighOpen() {
        return highOpen;
    }

    public void setHighOpen(long highOpen) {
        this.highOpen = highOpen;
    }

    public long getMediumOpen() {
        return mediumOpen;
    }

    public void setMediumOpen(long mediumOpen) {
        this.mediumOpen = mediumOpen;
    }

    public long getLowOpen() {
        return lowOpen;
    }

    public void setLowOpen(long lowOpen) {
        this.lowOpen = lowOpen;
    }
}