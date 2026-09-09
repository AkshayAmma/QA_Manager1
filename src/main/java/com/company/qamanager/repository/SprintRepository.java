package com.company.qamanager.repository;

import com.company.qamanager.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository
        extends JpaRepository<Sprint, Long> {
}