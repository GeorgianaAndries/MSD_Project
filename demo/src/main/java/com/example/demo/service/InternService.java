package com.example.demo.service;

import com.example.demo.dto.InternDto;
import com.example.demo.model.Intern;
import com.example.demo.repository.InternRepository;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternService {

    private final InternRepository internRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public InternService(InternRepository internRepository, ModelMapper modelMapper) {
        this.internRepository = internRepository;
        this.modelMapper = modelMapper;
    }

    
    public List<InternDto> getAllInterns(){
        return internRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
    }

    
    public Intern save(InternDto internDto){
        Intern intern = transformToModel(internDto);
        internRepository.save(intern);
        return intern;
    }


    public void update(InternDto internDto){
        Intern intern = transformToModel(internDto);
        internRepository.save(intern);
    }
    

    public Intern getInternById (int id){
        return internRepository.findById(id);
    }

    
    public List<Intern> getInternByProjectName(String projectName){
        return internRepository.findByProject(projectName);
    }
    
    
    public void delete(int id){
        internRepository.deleteById(id);
    }
    
    
    public void deleteProject(int internId){
        Intern intern = internRepository.findById(internId);
        intern.setProject(null);
        internRepository.save(intern);
    }
    
    
    public InternDto transformToDto(Intern source){
        return modelMapper.map(source, InternDto.class);
    }
    
    
    public Intern transformToModel(InternDto source){
        return modelMapper.map(source, Intern.class);
    }
}
