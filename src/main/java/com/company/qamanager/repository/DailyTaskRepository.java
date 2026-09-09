package com.company.qamanager.repository;

import com.company.qamanager.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DailyTaskRepository
        extends JpaRepository<DailyTask, Long> {

    @Query("""
           SELECT COALESCE(SUM(d.testCasesExecuted),0)
           FROM DailyTask d
           """)
    Integer getTotalExecutedCases();

    @Query("""
           SELECT COALESCE(SUM(d.hoursWorked),0)
           FROM DailyTask d
           """)
    Double getTotalHours();

    @Query("""
           SELECT COALESCE(SUM(d.defectsRaised),0)
           FROM DailyTask d
           """)
    Integer getTotalDefects();

    @Query("""
SELECT COUNT(t)
FROM DailyTask t
""")
    long totalTasks();

    @Query("""
SELECT COALESCE(SUM(t.hoursWorked),0)
FROM DailyTask t
""")
    Double totalHours();
    @Query("""
SELECT COALESCE(SUM(t.testCasesExecuted),0)
FROM DailyTask t
""")
    Integer executedCases();

    @Query("""
SELECT COALESCE(SUM(t.defectsRaised),0)
FROM DailyTask t
""")
    Long totalRaisedDefects();


    List<DailyTask> findByEmployeeId(Long employeeId);

}