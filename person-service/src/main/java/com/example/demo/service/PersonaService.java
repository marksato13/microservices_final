package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;
	
	public List<Persona> Listar(){
		return personaRepository.findAll();
	}
	
	public Optional<Persona> findById(int id){
		return personaRepository.findById(id);
	}
	public void delete(int id) {
		personaRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return personaRepository.existsById(id);
	}
	public void save(Persona persona) {
		personaRepository.save(persona);
	}

}
