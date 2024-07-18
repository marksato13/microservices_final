package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Persona;
import com.springboot.repository.PersonaRepository;
import com.springboot.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService<Persona>{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona create(Persona t) {
		// TODO Auto-generated method stub
		return personaRepository.save(t);
	}

	@Override
	public Persona update(Persona t) {
		// TODO Auto-generated method stub
		return personaRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}

	@Override
	public Optional<Persona> read(int id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

}