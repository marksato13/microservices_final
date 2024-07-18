package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Asistencia;
import com.example.demo.repository.AsistenciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AsistenciaService {
	@Autowired
	AsistenciaRepository asistenciaRepository;
	
	public List<Asistencia> Listar(){
		return asistenciaRepository.findAll();
	}
	
	public Optional<Asistencia> findById(int id){
		return asistenciaRepository.findById(id);
	}
	public void delete(int id) {
		asistenciaRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return asistenciaRepository.existsById(id);
	}
	public void save(Asistencia asistencia) {
		asistenciaRepository.save(asistencia);
	}

}
