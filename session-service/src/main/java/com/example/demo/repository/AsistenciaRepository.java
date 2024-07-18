package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia,Integer> {
	
}
