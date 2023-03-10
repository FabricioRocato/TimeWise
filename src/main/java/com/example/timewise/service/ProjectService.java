package com.example.timewise.service;

import com.example.timewise.model.Project;
import com.example.timewise.repository.ProjectRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository repository;
    @Autowired
    private TimeSheetService timeSheetService;

    public void save(Project project) {
        repository.save(project);
    }

    public Project findProject(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    public void deleteById(Long projectId) {
        if (repository.existsCustomer(projectId)){
            throw new ValidationException("Projeto vinculado a um cliente");
        }else if (timeSheetService.validExistisProject(projectId)) {
            throw new ValidationException("Projeto tem horas lançadas impossivel deletar");
        }else {
            repository.deleteById(projectId);
        }

    }
    public Page<Project> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }
}

