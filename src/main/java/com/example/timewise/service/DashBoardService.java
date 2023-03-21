package com.example.timewise.service;

import com.example.timewise.model.TimeSheet;
import com.example.timewise.repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class DashBoardService {

    @Autowired
    private TimeSheetRepository repository;

    public Page<TimeSheet> getTimeSheetByEmployee(Integer pageNumber, Integer pageSize) {
        return repository.getTimeSheets(PageRequest.of(pageNumber, pageSize));
    }
    public Page<TimeSheet> getTimeSheetByProject(Integer pageNumber, Integer pageSize) {
        return repository.getTimeSheets(PageRequest.of(pageNumber, pageSize));
    }



}