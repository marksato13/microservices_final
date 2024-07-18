package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipoSes;
import com.example.demo.repository.TipoSesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoSesService {
	@Autowired
	TipoSesRepository tipoSesRepository;
	
	public List<TipoSes> Listar(){
		return tipoSesRepository.findAll();
	}
	
	public Optional<TipoSes> findById(int id){
		return tipoSesRepository.findById(id);
	}
	public void delete(int id) {
		tipoSesRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return tipoSesRepository.existsById(id);
	}
	public void save(TipoSes tiposes) {
		tipoSesRepository.save(tiposes);
	}

}
