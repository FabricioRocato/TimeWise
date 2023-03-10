package com.example.timewise.repository;

import com.example.timewise.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(nativeQuery = true , value = "select * from employee e where e.supervisor is not true and e.name like :searchTerm")
    Page<Employee> findByEmployee(@Param("searchTerm") String searchTerm, Pageable pageable);
    @Query(nativeQuery = true , value = "select * from employee e where e.name like :searchTerm")
    Page<Employee> getListEmployee(@Param("searchTerm") String searchTerm,Pageable pageable);

    @Query(nativeQuery = true , value = "select * from employee e where e.supervisor is true and e.name like :searchTerm")
    Page<Employee> findBySupervidor(@Param("searchTerm") String searchTerm,Pageable pageable);
}
