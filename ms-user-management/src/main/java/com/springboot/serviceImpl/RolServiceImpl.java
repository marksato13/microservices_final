package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Rol;
import com.springboot.repository.RolRepository;
import com.springboot.service.RolService;

@Service

public class RolServiceImpl implements RolService<Rol>{
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Rol create(Rol t) {
		// TODO Auto-generated method stub
		return rolRepository.save(t);
	}

	@Override
	public Rol update(Rol t) {
		// TODO Auto-generated method stub
		return rolRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
	}

	@Override
	public Optional<Rol> read(int id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

}