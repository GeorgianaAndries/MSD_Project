package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="project_name")
  private String projectName;
  
  @Column(name="start_date")
  private String startDate;
  
  @Column(name="end_date")
  private String endDate;
  
  @Column
  private String client;
  
  @Column
  private Double salary;
  
  @Column
  private String team;
}
