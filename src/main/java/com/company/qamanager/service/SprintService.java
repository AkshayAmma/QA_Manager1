package com.company.qamanager.service;

import com.company.qamanager.entity.Sprint;
import com.company.qamanager.repository.SprintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    private final SprintRepository repository;

    public SprintService(SprintRepository repository) {
        this.repository = repository;
    }

    public Sprint save(Sprint sprint) {
        return repository.save(sprint);
    }

    public List<Sprint> findAll() {
        return repository.findAll();
    }
}