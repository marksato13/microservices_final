package com.springboot.service;

import java.util.List;
import java.util.Optional;

public interface UsuarioService  <T>{
	
	T create(T t);
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();

}	