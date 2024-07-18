package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Escuela;
import com.example.demo.repository.EscuelaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EscuelaService {
	@Autowired
	EscuelaRepository escuelaRepository;
	
	public List<Escuela> Listar(){
		return escuelaRepository.findAll();
	}
	
	public Optional<Escuela> findById(int id){
		return escuelaRepository.findById(id);
	}
	public void delete(int id) {
		escuelaRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return escuelaRepository.existsById(id);
	}
	public void save(Escuela escuela) {
		escuelaRepository.save(escuela);
	}

}
