package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Champions;
import com.example.demo.repository.ChampionsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ChampionsService {
	@Autowired
	ChampionsRepository championsRepository;
	
	public List<Champions> Listar(){
		return championsRepository.findAll();
	}
	
	public Optional<Champions> findById(int id){
		return championsRepository.findById(id);
	}
	public void delete(int id) {
		championsRepository.deleteById(id);
	}
	public boolean existById(int id) {
		return championsRepository.existsById(id);
	}
	public void save(Champions champions) {
		championsRepository.save(champions);
	}

}
