package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Integer> {
	
}
