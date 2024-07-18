package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Usuario_Rol;
import com.springboot.repository.Usuario_RolRepository;
import com.springboot.service.Usuario_RolService;

@Service
public class Usuario_RolServiceImpl implements Usuario_RolService<Usuario_Rol>{
	
	@Autowired
	private Usuario_RolRepository usuario_RolRepository;

	@Override
	public Usuario_Rol create(Usuario_Rol t) {
		// TODO Auto-generated method stub
		return usuario_RolRepository.save(t);
	}

	@Override
	public Usuario_Rol update(Usuario_Rol t) {
		// TODO Auto-generated method stub
		return usuario_RolRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuario_RolRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario_Rol> read(int id) {
		// TODO Auto-generated method stub
		return usuario_RolRepository.findById(id);
	}

	@Override
	public List<Usuario_Rol> readAll() {
		// TODO Auto-generated method stub
		return usuario_RolRepository.findAll();
	}

}