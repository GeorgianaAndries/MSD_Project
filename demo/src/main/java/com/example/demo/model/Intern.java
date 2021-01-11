package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="interns")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String city;
    
    @Column
    private String role;
    
    @Column
    private String mail;
    
    @Column
    private String telNo;
    
    @Column
    private String team;
    
    @Column
    private String project;
    
    @Column
    private Boolean paid;
    
    @Column(name="start_date")
    private String startDate;
    
    @Column(name="end_date")
    private String endDate;
    
}