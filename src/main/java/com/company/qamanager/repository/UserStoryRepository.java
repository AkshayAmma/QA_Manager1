package com.company.qamanager.repository;

import com.company.qamanager.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserStoryRepository
        extends JpaRepository<UserStory,Long> {

    @Query("""
           SELECT COALESCE(SUM(u.totalTestCases),0)
           FROM UserStory u
           """)
    Integer getTotalTestCases();

    @Query("""
SELECT COUNT(s)
FROM UserStory s
""")
    long totalStories();
}