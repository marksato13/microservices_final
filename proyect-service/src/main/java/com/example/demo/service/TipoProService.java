package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipoPro;
import com.example.demo.repository.TipoProRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoProService {
	@Autowired
	TipoProRepository tipoProRepository;
	
	public List<TipoPro> Listar(){
		return tipoProRepository.findAll();
	}
	
	public Optional<TipoPro> findById(int id){
		return tipoProRepository.findById(id);
	}
	
	public void delete(int id) {
		tipoProRepository.deleteById(id);
	}
	
	public boolean existById(int id) {
		return tipoProRepository.existsById(id);
	}
	
	public void save(TipoPro tipopro) {
		tipoProRepository.save(tipopro);
	}

}
