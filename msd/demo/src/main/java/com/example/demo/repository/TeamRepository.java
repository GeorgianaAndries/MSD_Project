package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
	@Transactional
    @Modifying
    @Query("UPDATE Team i " +
            "SET i.teamName=:teamName" + " WHERE i.id=:id")
    void updateTeam(@Param("teamName") String teamName,
                      @Param("id") int id);
}
