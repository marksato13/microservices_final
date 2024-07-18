package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Salon;
import com.example.demo.repository.SalonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SalonService {
	@Autowired
	SalonRepository salonRepository;
	
	public List<Salon> Listar(){
		return salonRepository.findAll();
	}
	
	public Optional<Salon> findById(int id){
		return salonRepository.findById(id);
	}
	public void delete(int id) {
		salonRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return salonRepository.existsById(id);
	}
	public void save(Salon salon) {
		salonRepository.save(salon);
	}

}
