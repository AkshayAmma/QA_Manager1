package com.company.qamanager.repository;

import com.company.qamanager.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DefectRepository
        extends JpaRepository<Defect,Long> {

    @Query("""
        SELECT COUNT(d)
        FROM Defect d
    """)
    long totalDefects();

    @Query("""
        SELECT COUNT(d)
        FROM Defect d
        WHERE d.rejected = true
    """)
    long rejectedDefects();

    @Query("""
        SELECT COUNT(d)
        FROM Defect d
        WHERE d.reopened = true
    """)
    long reopenedDefects();

    @Query("""
        SELECT COUNT(d)
        FROM Defect d
        WHERE d.uatLeakage = true
    """)
    long uatLeakageDefects();

    @Query("""
        SELECT COUNT(d)
        FROM Defect d
        WHERE d.productionLeakage = true
    """)
    long productionLeakageDefects();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.severity='Critical'
""")
    long criticalDefects();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.productionLeakage=true
""")
    long productionLeakageCount();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.severity='High'
""")
    long highCount();
    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.severity='Critical'
""")
    long criticalCount();
    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.severity='Low'
""")
    long lowCount();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.severity='Medium'
""")
    long mediumCount();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.productionLeakage=true
""")
    long productionDefects();

    @Query("""
SELECT COUNT(d)
FROM Defect d
""")
    long allDefects();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Closed'
""")
    long closedDefects();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.reopened=false
AND d.status='Closed'
""")
    long closedWithoutReopen();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Open'
AND d.severity='High'
""")
    long highOpen();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Open'
AND d.severity='Critical'
""")
    long criticalOpen();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Open'
AND d.severity='Low'
""")
    long lowOpen();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Open'
AND d.severity='Medium'
""")
    long mediumOpen();

    @Query("""
SELECT COUNT(d)
FROM Defect d
WHERE d.status='Open'
""")
    long pendingDefects();



}