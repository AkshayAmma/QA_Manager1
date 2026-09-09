package com.company.qamanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "defects")
public class Defect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String defectId;
    private String storyId;
    private String summary;
    private String severity;
    private String status;

    private Boolean reopened;
    private Boolean rejected;
    private Boolean uatLeakage;
    private Boolean productionLeakage;

    private LocalDate createdDate;

    public Defect() {
    }

    public Long getId() {
        return id;
    }

    public String getDefectId() {
        return defectId;
    }

    public void setDefectId(String defectId) {
        this.defectId = defectId;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getReopened() {
        return reopened;
    }

    public void setReopened(Boolean reopened) {
        this.reopened = reopened;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Boolean getUatLeakage() {
        return uatLeakage;
    }

    public void setUatLeakage(Boolean uatLeakage) {
        this.uatLeakage = uatLeakage;
    }

    public Boolean getProductionLeakage() {
        return productionLeakage;
    }

    public void setProductionLeakage(Boolean productionLeakage) {
        this.productionLeakage = productionLeakage;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}