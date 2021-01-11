package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InternDto {
    private int id;
    
    private String name;
    
    private String city;
    
    private String role;
    
    private String mail;
    
    private String telNo;
    
    private String team;
    
    private String project;
    
    private Boolean paid;
    
    private String startDate;
    
    private String endDate;
    
}