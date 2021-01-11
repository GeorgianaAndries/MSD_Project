package com.example.demo.repository;

import com.example.demo.model.Intern;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InternRepository extends JpaRepository<Intern, Integer> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE Intern i " +
//            "SET i.name=:name" + " WHERE i.id=:id")
//    void updateIntern(@Param("name") String name,
//                      @Param("id") int id);
    
    Intern findById(int id);
    
    List<Intern> findByProject(String project);

}
