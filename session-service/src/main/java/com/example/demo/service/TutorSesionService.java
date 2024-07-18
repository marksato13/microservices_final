package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TutorSesion;
import com.example.demo.repository.TutorSesionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TutorSesionService {
	@Autowired
	TutorSesionRepository tutorSesionRepository;
	
	public List<TutorSesion> Listar(){
		return tutorSesionRepository.findAll();
	}
	
	public Optional<TutorSesion> findById(int id){
		return tutorSesionRepository.findById(id);
	}
	public void delete(int id) {
		tutorSesionRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return tutorSesionRepository.existsById(id);
	}
	public void save(TutorSesion tutorSesion) {
		tutorSesionRepository.save(tutorSesion);
	}

}
