package com.example.demo.service;

import com.example.demo.dto.InternDto;
import com.example.demo.model.Intern;
import com.example.demo.repository.InternRepository;
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
        Intern intern = modelMapper.map(internDto, Intern.class);
        internRepository.save(intern);
        return intern;
    }

    public void delete(int id){
        internRepository.deleteById(id);
    }

    public void update(InternDto internDto){
        internRepository.updateIntern(internDto.getName(),internDto.getId());
    }

    public Intern getInternById (int id){
        return internRepository.findById(id).get();
    }

    public InternDto transformToDto(Intern source){
        return modelMapper.map(source, InternDto.class);

    }
}