package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Lugar;

@Repository
public interface LugarRepository extends JpaRepository<Lugar,Integer> {
	
}
