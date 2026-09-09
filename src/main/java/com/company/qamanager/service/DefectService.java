package com.company.qamanager.service;

import com.company.qamanager.entity.Defect;
import com.company.qamanager.repository.DefectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectService {

    private final DefectRepository repository;

    public DefectService(
            DefectRepository repository) {

        this.repository = repository;
    }

    public Defect save(
            Defect defect) {

        return repository.save(defect);
    }

    public List<Defect> findAll() {

        return repository.findAll();
    }
}