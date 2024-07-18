package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Disciplina;
import com.example.demo.repository.DisciplinaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DisciplinaService {
	@Autowired
	DisciplinaRepository discplRepository;
	
	public List<Disciplina> Listar(){
		return discplRepository.findAll();
	}
	
	public Optional<Disciplina> findById(int id){
		return discplRepository.findById(id);
	}
	public void delete(int id) {
		discplRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return discplRepository.existsById(id);
	}
	public void save(Disciplina disciplina) {
		discplRepository.save(disciplina);
	}

}
