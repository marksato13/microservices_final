package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Facultad;
import com.example.demo.repository.FacultadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacultadService {
	@Autowired
	FacultadRepository facultadRepository;
	
	public List<Facultad> Listar(){
		return facultadRepository.findAll();
	}
	
	public Optional<Facultad> findById(int id){
		return facultadRepository.findById(id);
	}
	public void delete(int id) {
		facultadRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return facultadRepository.existsById(id);
	}
	public void save(Facultad facultad) {
		facultadRepository.save(facultad);
	}

}
