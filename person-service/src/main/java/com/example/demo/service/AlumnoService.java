package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.repository.AlumnoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public List<Alumno> Listar(){
		return alumnoRepository.findAll();
	}
	
	public Optional<Alumno> findById(int id){
		return alumnoRepository.findById(id);
	}
	public void delete(int id) {
		alumnoRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return alumnoRepository.existsById(id);
	}
	public void save(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

}
