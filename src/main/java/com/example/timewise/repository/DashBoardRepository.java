package com.example.timewise.repository;

import com.example.timewise.model.TimeSheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashBoardRepository extends JpaRepository<TimeSheet, Long> {

    @Query(value = "select ts from TimeSheet ts WHERE ts.employee ilike :searchTerm order by id desc")
    Page<TimeSheet> getTimeSheetByEmployee(Pageable pageable);

    @Query(value = "select ts from TimeSheet ts order by id desc")
    Page<TimeSheet> getTimeSheetByProject(Pageable pageable);

}