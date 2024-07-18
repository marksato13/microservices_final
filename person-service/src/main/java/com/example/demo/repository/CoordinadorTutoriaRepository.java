package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.CoordinadorTutoria;

@Repository
public interface CoordinadorTutoriaRepository extends JpaRepository<CoordinadorTutoria,Integer> {
	
}
