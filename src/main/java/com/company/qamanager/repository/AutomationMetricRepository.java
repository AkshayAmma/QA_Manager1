package com.company.qamanager.repository;

import com.company.qamanager.entity.AutomationMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutomationMetricRepository
        extends JpaRepository<AutomationMetrics, Long> {

    @Query("""
            SELECT COALESCE(SUM(a.totalTestCases),0)
            FROM AutomationMetrics a
            """)
    Integer totalTestCases();

    @Query("""
            SELECT COALESCE(SUM(a.automatedCases),0)
            FROM AutomationMetrics a
            """)
    Integer automatedCases();

    @Query("""
            SELECT COALESCE(SUM(a.totalApis),0)
            FROM AutomationMetrics a
            """)
    Integer totalApis();

    @Query("""
            SELECT COALESCE(SUM(a.automatedApis),0)
            FROM AutomationMetrics a
            """)
    Integer automatedApis();

    @Query("""
            SELECT COALESCE(SUM(a.executedScripts),0)
            FROM AutomationMetrics a
            """)
    Integer executedScripts();

    @Query("""
            SELECT COALESCE(SUM(a.passedScripts),0)
            FROM AutomationMetrics a
            """)
    Integer passedScripts();

    @Query("""
            SELECT COALESCE(SUM(a.failedScripts),0)
            FROM AutomationMetrics a
            """)
    Integer failedScripts();

    @Query("""
SELECT COALESCE(SUM(a.passedScripts),0)
FROM AutomationMetrics a
""")
    Integer totalPassedCases();
}