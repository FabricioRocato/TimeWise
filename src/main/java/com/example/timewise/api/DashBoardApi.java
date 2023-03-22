package com.example.timewise.api;

import com.example.timewise.model.TimeSheet;
import com.example.timewise.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dashboard")
public class DashBoardApi {

    @Autowired
    private TimeSheetService service;

    @GetMapping("employee")
    public Page<TimeSheet> findByEmployeeIdOrderByIdDesc(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                         @RequestParam Long employee) {
        return service.findByEmployeeIdOrderByIdDesc(pageNumber, pageSize, employee);
    }
    @GetMapping("project")
    public Page<TimeSheet> findByProjectIdOrderByIdDesc(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
                                                         @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                                         @RequestParam Long employee) {
        return service.findByProjectIdOrderByIdDesc(pageNumber, pageSize, employee);
    }

}