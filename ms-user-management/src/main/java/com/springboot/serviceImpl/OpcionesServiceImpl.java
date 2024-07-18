package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Opciones;
import com.springboot.repository.OpcionesRepository;
import com.springboot.service.OpcionesService;

@Service
public class OpcionesServiceImpl implements OpcionesService<Opciones>{
	
	@Autowired
	private OpcionesRepository opcionesRepository;

	@Override
	public Opciones create(Opciones t) {
		// TODO Auto-generated method stub
		return opcionesRepository.save(t);
	}

	@Override
	public Opciones update(Opciones t) {
		// TODO Auto-generated method stub
		return opcionesRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		opcionesRepository.deleteById(id);
	}

	@Override
	public Optional<Opciones> read(int id) {
		// TODO Auto-generated method stub
		return opcionesRepository.findById(id);
	}

	@Override
	public List<Opciones> readAll() {
		// TODO Auto-generated method stub
		return opcionesRepository.findAll();
	}

}