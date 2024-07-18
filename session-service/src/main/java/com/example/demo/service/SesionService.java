package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sesion;
import com.example.demo.repository.SesionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SesionService {
	@Autowired
	SesionRepository sesionRepository;
	
	public List<Sesion> Listar(){
		return sesionRepository.findAll();
	}
	
	public Optional<Sesion> findById(int id){
		return sesionRepository.findById(id);
	}
	public void delete(int id) {
		sesionRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return sesionRepository.existsById(id);
	}
	public void save(Sesion sesion) {
		sesionRepository.save(sesion);
	}

	public List<Sesion> searchSesionbyPro(int idProyecto){
		return sesionRepository.findSesionbyProQueryNative(idProyecto);
	}
	
	
	 // Método para obtener sesiones por proyecto usando el ID del proyecto
    public List<Map<String, Object>> findSesionByProyecto(int idProyecto) {
        return sesionRepository.findSesionByProyecto(idProyecto);
    }
}
