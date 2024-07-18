package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tutor;
import com.example.demo.repository.TutorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TutorService {
	@Autowired
	TutorRepository tutorRepository;
	
	public List<Tutor> Listar(){
		return tutorRepository.findAll();
	}
	
	public Optional<Tutor> findById(int id){
		return tutorRepository.findById(id);
	}
	public void delete(int id) {
		tutorRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return tutorRepository.existsById(id);
	}
	public void save(Tutor tutor) {
		tutorRepository.save(tutor);
	}

}
