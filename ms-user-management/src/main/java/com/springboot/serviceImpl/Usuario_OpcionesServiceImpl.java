//package com.springboot.serviceImpl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springboot.entity.Usuario_Opciones;
//import com.springboot.repository.Usuario_OpcionesRepository;
//import com.springboot.service.Usuario_OpcionesService;
//
//@Service
//public class Usuario_OpcionesServiceImpl implements Usuario_OpcionesService<Usuario_Opciones>{
//	
//	@Autowired
//	private Usuario_OpcionesRepository usuario_OpcionesRepository;
//
//	@Override
//	public Usuario_Opciones create(Usuario_Opciones t) {
//		// TODO Auto-generated method stub
//		return usuario_OpcionesRepository.save(t);
//	}
//
//	@Override
//	public Usuario_Opciones update(Usuario_Opciones t) {
//		// TODO Auto-generated method stub
//		return usuario_OpcionesRepository.save(t);
//	}
//
//	@Override
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		usuario_OpcionesRepository.deleteById(id);
//	}
//
//	@Override
//	public Optional<Usuario_Opciones> read(int id) {
//		// TODO Auto-generated method stub
//		return usuario_OpcionesRepository.findById(id);
//	}
//
//	@Override
//	public List<Usuario_Opciones> readAll() {
//		// TODO Auto-generated method stub
//		return usuario_OpcionesRepository.findAll();
//	}
//
//}