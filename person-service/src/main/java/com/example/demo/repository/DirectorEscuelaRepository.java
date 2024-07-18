package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.DirectorEscuela;

@Repository
public interface DirectorEscuelaRepository extends JpaRepository<DirectorEscuela,Integer> {
	
}
