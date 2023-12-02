package com.example.repository;

import com.example.entities.LogApiRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogApiRestRepository extends JpaRepository<LogApiRest,String> {
}
