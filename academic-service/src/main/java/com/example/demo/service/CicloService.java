package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciclo;
import com.example.demo.repository.CicloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CicloService {
	@Autowired
	CicloRepository cicloRepository;
	
	public List<Ciclo> Listar(){
		return cicloRepository.findAll();
	}
	
	public Optional<Ciclo> findById(int id){
		return cicloRepository.findById(id);
	}
	public void delete(int id) {
		cicloRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return cicloRepository.existsById(id);
	}
	public void save(Ciclo ciclo) {
		cicloRepository.save(ciclo);
	}

}

