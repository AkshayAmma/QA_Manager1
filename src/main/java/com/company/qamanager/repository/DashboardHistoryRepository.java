package com.company.qamanager.repository;

import com.company.qamanager.entity.DashboardHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashboardHistoryRepository
        extends JpaRepository<DashboardHistory, Long> {

    List<DashboardHistory> findAllByOrderByCreatedDateAsc();

}