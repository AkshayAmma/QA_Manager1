package com.company.qamanager.service;

import com.company.qamanager.dto.DefectAgingDto;
import com.company.qamanager.entity.Defect;
import com.company.qamanager.repository.DefectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DefectAgingService {

    private final DefectRepository repository;

    public DefectAgingService(
            DefectRepository repository) {

        this.repository = repository;
    }

    public DefectAgingDto getDefectAging() {

        List<Defect> defects =
                repository.findAll();

        DefectAgingDto dto =
                new DefectAgingDto();

        long age0To5 = 0;
        long age6To10 = 0;
        long age11To20 = 0;
        long age20Plus = 0;

        for (Defect defect : defects) {

            if(defect.getCreatedDate() == null) {
                continue;
            }

            long age =
                    ChronoUnit.DAYS.between(
                            defect.getCreatedDate(),
                            LocalDate.now()
                    );

            if(age <= 5) {
                age0To5++;
            }
            else if(age <= 10) {
                age6To10++;
            }
            else if(age <= 20) {
                age11To20++;
            }
            else {
                age20Plus++;
            }
        }

        dto.setAge0To5(age0To5);
        dto.setAge6To10(age6To10);
        dto.setAge11To20(age11To20);
        dto.setAge20Plus(age20Plus);

        return dto;
    }
}