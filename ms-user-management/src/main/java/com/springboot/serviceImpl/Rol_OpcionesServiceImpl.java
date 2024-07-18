package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Rol_Opciones;
import com.springboot.repository.Rol_OpcionesRepository;
import com.springboot.service.Rol_OpcionesService;

@Service
public class Rol_OpcionesServiceImpl implements Rol_OpcionesService<Rol_Opciones>{
	
	@Autowired
	private Rol_OpcionesRepository rol_OpcionesRepository;

	@Override
	public Rol_Opciones create(Rol_Opciones t) {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.save(t);
	}

	@Override
	public Rol_Opciones update(Rol_Opciones t) {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rol_OpcionesRepository.deleteById(id);
	}

	@Override
	public Optional<Rol_Opciones> read(int id) {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.findById(id);
	}

	@Override
	public List<Rol_Opciones> readAll() {
		// TODO Auto-generated method stub
		return rol_OpcionesRepository.findAll();
	}

}