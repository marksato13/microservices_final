package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Integer> {
	
}
