package com.company.qamanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sprints")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String sprintName;

    private Integer plannedStoryPoints;
    private Integer completedStoryPoints;

    private Integer plannedStories;

    private Integer completedStories;

    private Integer initialRequirements;

    private Integer finalRequirements;

    private LocalDate plannedEndDate;

   private LocalDate actualEndDate;

   public Sprint() {
    }

    public Long getId() {
        return id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Integer getPlannedStoryPoints() {
        return plannedStoryPoints;
    }

    public void setPlannedStoryPoints(Integer plannedStoryPoints) {
        this.plannedStoryPoints = plannedStoryPoints;
    }

    public Integer getCompletedStoryPoints() {
        return completedStoryPoints;
    }

    public void setCompletedStoryPoints(Integer completedStoryPoints) {
        this.completedStoryPoints = completedStoryPoints;
    }

    public Integer getPlannedStories() {
        return plannedStories;
    }

    public void setPlannedStories(Integer plannedStories) {
        this.plannedStories = plannedStories;
    }

    public Integer getCompletedStories() {
        return completedStories;
    }

    public void setCompletedStories(Integer completedStories) {
        this.completedStories = completedStories;
    }

    public Integer getInitialRequirements() {
        return initialRequirements;
    }

    public void setInitialRequirements(Integer initialRequirements) {
        this.initialRequirements = initialRequirements;
    }

    public Integer getFinalRequirements() {
        return finalRequirements;
    }

    public void setFinalRequirements(Integer finalRequirements) {
        this.finalRequirements = finalRequirements;
    }

    public LocalDate getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(LocalDate plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public LocalDate getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
    }
}