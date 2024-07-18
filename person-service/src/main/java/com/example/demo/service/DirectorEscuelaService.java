package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DirectorEscuela;
import com.example.demo.repository.DirectorEscuelaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DirectorEscuelaService {
	@Autowired
	DirectorEscuelaRepository directorescRepository;
	
	public List<DirectorEscuela> Listar(){
		return directorescRepository.findAll();
	}
	
	public Optional<DirectorEscuela> findById(int id){
		return directorescRepository.findById(id);
	}
	public void delete(int id) {
		directorescRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return directorescRepository.existsById(id);
	}
	public void save(DirectorEscuela directoresc) {
		directorescRepository.save(directoresc);
	}

}
