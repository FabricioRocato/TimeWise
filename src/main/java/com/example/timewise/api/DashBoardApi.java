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
@RequestMapping("/dashboard")
public class DashBoardApi {

    @Autowired
    private TimeSheetService service;

    @GetMapping("/employee")
    public Page<TimeSheet> getTimeSheetByEmployee(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize ){
        return service.getTimeSheetByEmployee(pageNumber, pageSize);
    }


}