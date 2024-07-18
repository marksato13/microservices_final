package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Integer> {
	
}
