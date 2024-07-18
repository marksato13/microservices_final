package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Ciclo;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo,Integer> {
	
}
