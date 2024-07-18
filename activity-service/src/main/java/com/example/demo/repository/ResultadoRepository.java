package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado,Integer> {
	
}
