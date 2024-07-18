package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Lugar;
import com.example.demo.repository.LugarRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LugarService {
	@Autowired
	LugarRepository lugarRepository;
	
	public List<Lugar> Listar(){
		return lugarRepository.findAll();
	}
	
	public Optional<Lugar> findById(int id){
		return lugarRepository.findById(id);
	}
	public void delete(int id) {
		lugarRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return lugarRepository.existsById(id);
	}
	public void save(Lugar lugar) {
		lugarRepository.save(lugar);
	}

}