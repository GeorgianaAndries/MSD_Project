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

    @PostMapping("/interns")
    private int saveIntern(@RequestBody InternDto internDto){
        Intern internCreated = internService.save(internDto);
        InternDto intern = modelMapper.map(internCreated, InternDto.class);
        return intern.getId();
    }

    @GetMapping("/interns")
    private List<InternDto> getInterns(){
        return internService.getAllInterns();
    }

    @GetMapping("/intern/{intern_id}")
    private Intern getInternById(@PathVariable("intern_id") int internId){
        return internService.getInternById(internId);
    }

    @DeleteMapping("/intern/{intern_id}")
    private void deleteInternById(@PathVariable("intern_id") int internId){
        internService.delete(internId);
    }

    @PutMapping("/intern_update")
    private void update(@RequestBody InternDto internDto){
        internService.update(internDto);
    }
}
