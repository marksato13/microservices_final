package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Participacion;
import com.example.demo.repository.ParticipacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ParticipacionService {
	@Autowired
	ParticipacionRepository particRepository;
	
	public List<Participacion> Listar(){
		return particRepository.findAll();
	}
	
	public Optional<Participacion> findById(int id){
		return particRepository.findById(id);
	}
	public void delete(int id) {
		particRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return particRepository.existsById(id);
	}
	public void save(Participacion partic) {
		particRepository.save(partic);
	}

}
