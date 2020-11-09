package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Transactional
    @Modifying
    @Query("UPDATE User i " +
            "SET i.name=:name" + " WHERE i.id=:id")
    void updateUser(@Param("name") String name,
                      @Param("id") int id);
}
