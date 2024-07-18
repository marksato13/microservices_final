package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Resultado;
import com.example.demo.repository.ResultadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResultadoService {
	@Autowired
	ResultadoRepository resultRepository;
	
	public List<Resultado> Listar(){
		return resultRepository.findAll();
	}
	
	public Optional<Resultado> findById(int id){
		return resultRepository.findById(id);
	}
	public void delete(int id) {
		resultRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return resultRepository.existsById(id);
	}
	public void save(Resultado result) {
		resultRepository.save(result);
	}

}
