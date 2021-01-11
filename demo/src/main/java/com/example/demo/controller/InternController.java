package com.example.demo.controller;

import com.example.demo.dto.InternDto;
import com.example.demo.model.Intern;
import com.example.demo.service.InternService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternController {

    private final InternService internService;
    private final ModelMapper modelMapper;

    @Autowired
    public InternController(InternService internService, ModelMapper modelMapper) {
        this.internService = internService;
        this.modelMapper = modelMapper;
    }

    
    @GetMapping("/intern")
    private List<InternDto> getInterns(){
        return internService.getAllInterns();
    }

    
    @GetMapping("/interns/{intern_id}")
    private Intern getInternById(@PathVariable("intern_id") int internId){
        return internService.getInternById(internId);
    }
    
    
    @GetMapping("/interns-by-project/{projectName}")
    private List<Intern> getInternByProjectName(@PathVariable("projectName") String projectName){
        return internService.getInternByProjectName(projectName);
    }
    
    
    @PostMapping("/interns")
    private int saveIntern(@RequestBody InternDto internDto){
        Intern internCreated = internService.save(internDto);
        InternDto intern = modelMapper.map(internCreated, InternDto.class);
        return intern.getId();
    }
    
    
    @PutMapping("/intern_update")
    private void update(@RequestBody InternDto internDto){
        internService.update(internDto);
    }
    
    
    @DeleteMapping("/interns/{intern_id}")
    private void deleteInternById(@PathVariable("intern_id") int internId){
        internService.delete(internId);
    }
    
    
    @DeleteMapping("/interns-project/{internId}")
    private void deleteInternProject(@PathVariable("internId") int internId){
        internService.deleteProject(internId);
    }

}
