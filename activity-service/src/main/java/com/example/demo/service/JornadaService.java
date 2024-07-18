package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jornada;
import com.example.demo.repository.JornadaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JornadaService {
	@Autowired
	JornadaRepository jornadaRepository;
	
	public List<Jornada> Listar(){
		return jornadaRepository.findAll();
	}
	
	public Optional<Jornada> findById(int id){
		return jornadaRepository.findById(id);
	}
	public void delete(int id) {
		jornadaRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return jornadaRepository.existsById(id);
	}
	public void save(Jornada jornada) {
		jornadaRepository.save(jornada);
	}

}
