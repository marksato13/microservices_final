package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CoordinadorTutoria;
import com.example.demo.repository.CoordinadorTutoriaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CoordinadorTutoriaService {
	@Autowired
	CoordinadorTutoriaRepository coordinadorTutoriaRepository;
	
	public List<CoordinadorTutoria> Listar(){
		return coordinadorTutoriaRepository.findAll();
	}
	
	public Optional<CoordinadorTutoria> findById(int id){
		return coordinadorTutoriaRepository.findById(id);
	}
	public void delete(int id) {
		coordinadorTutoriaRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return coordinadorTutoriaRepository.existsById(id);
	}
	public void save(CoordinadorTutoria coordtut) {
		coordinadorTutoriaRepository.save(coordtut);
	}

}
