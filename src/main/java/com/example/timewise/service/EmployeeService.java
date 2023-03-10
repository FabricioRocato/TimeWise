package com.example.timewise.service;

import com.example.timewise.model.Employee;
import com.example.timewise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public void save(Employee employee) {
        repository.save(employee);

    }
    public Page<Employee> findByEmployee(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByEmployee("%"+searchTerm+"%", PageRequest.of(pageNumber, pageSize));
    }

    public Page<Employee> getListEmployee(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.getListEmployee("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }

    public Page<Employee> findBySupervidor(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findBySupervidor("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }
    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }

}
