package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	@Transactional
    @Modifying
    @Query("UPDATE Project i " +
            "SET i.projectName=:projectName" + " WHERE i.id=:id")
    void updateProject(@Param("projectName") String projectName,
                      @Param("id") int id);
	

}
