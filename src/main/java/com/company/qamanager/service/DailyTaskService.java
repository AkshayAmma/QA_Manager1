package com.company.qamanager.service;

import com.company.qamanager.entity.DailyTask;
import com.company.qamanager.repository.DailyTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTaskService {

    private final DailyTaskRepository repository;

    public DailyTaskService(
            DailyTaskRepository repository) {

        this.repository = repository;
    }

    public DailyTask save(
            DailyTask task) {

        return repository.save(task);
    }

    public List<DailyTask> findAll() {

        return repository.findAll();
    }
}