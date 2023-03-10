package com.example.timewise.service;

import com.example.timewise.model.TimeSheet;
import com.example.timewise.repository.TimeSheetRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TimeSheetService {

    @Autowired
    private TimeSheetRepository repository;

    public void save(TimeSheet timeSheet) {
        repository.save(timeSheet);
    }

    public void deleteById(Long timeSheetId) {
        repository.deleteById(timeSheetId);
    }

    public Page<TimeSheet> getTimeSheets(Integer pageNumber, Integer pageSize) {
        return repository.getTimeSheets(PageRequest.of(pageNumber, pageSize));
    }

    public Boolean validExistisProject(Long projectId){
        return repository.existsProjectById(projectId);
    }
}
