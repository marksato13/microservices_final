package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Partido;
import com.example.demo.repository.PartidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PartidoService {
	@Autowired
	PartidoRepository partidoRepository;
	
	public List<Partido> Listar(){
		return partidoRepository.findAll();
	}
	
	public Optional<Partido> findById(int id){
		return partidoRepository.findById(id);
	}
	public void delete(int id) {
		partidoRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return partidoRepository.existsById(id);
	}
	public void save(Partido partido) {
		partidoRepository.save(partido);
	}

}
