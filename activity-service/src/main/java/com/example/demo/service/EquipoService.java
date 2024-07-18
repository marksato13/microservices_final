package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Equipo;
import com.example.demo.repository.EquipoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EquipoService {
	@Autowired
	EquipoRepository equipoRepository;
	
	public List<Equipo> Listar(){
		return equipoRepository.findAll();
	}
	
	public Optional<Equipo> findById(int id){
		return equipoRepository.findById(id);
	}
	public void delete(int id) {
		equipoRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return equipoRepository.existsById(id);
	}
	public void save(Equipo equipo) {
		equipoRepository.save(equipo);
	}

}
