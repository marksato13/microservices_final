package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proyecto;
import com.example.demo.repository.ProyectoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyectoService {
	@Autowired
	ProyectoRepository proyectoRepository;
	
	public List<Proyecto> Listar(){
		return proyectoRepository.findAll();
	}
	
	public Optional<Proyecto> findById(int id){
		return proyectoRepository.findById(id);
	}
	public void delete(int id) {
		proyectoRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return proyectoRepository.existsById(id);
	}
	public void save(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}
	
    public List<Proyecto> findBySemestre(int idSemestre){
        return proyectoRepository.findBySemestreIdSemestre(idSemestre);
    }
    
    public List<Proyecto> findByTipoPro(int idTipoPro){
        return proyectoRepository.findByTipoproIdTipoPro(idTipoPro);
    }
    
    public List<Proyecto> findBySemestreAndTipoPro(int idSemestre, int idTipoPro){
        return proyectoRepository.findBySemestreIdSemestreAndTipoproIdTipoPro(idSemestre, idTipoPro);
    }


}
