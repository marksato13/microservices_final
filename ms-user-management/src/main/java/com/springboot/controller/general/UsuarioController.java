package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Usuario;
import com.springboot.serviceImpl.UsuarioServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.springboot.commons.GlobalConstans.API_USUARIO;

@RestController
@RequestMapping(API_USUARIO)
@CrossOrigin({"*"})

public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	
	@GetMapping("/initSesion/{user}/{pass}")
	public ResponseEntity<List<Map<String, Object>>> listarModulos(@PathVariable("user") String user,@PathVariable("pass") String pass ) {
		try {
			  System.out.println(user +" "+ pass);
		      List<Map<String, Object>> modulos = usuarioServiceImpl.getInitSesion(user,pass); 
		      if (modulos.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(modulos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/modules/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarModulesRol(@PathVariable("id") int id) {
		try {
		      List<Map<String, Object>> modulos = usuarioServiceImpl.getModules(id); 
		      if (modulos.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(modulos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/ListUser")
	public ResponseEntity<List<Usuario>> listar() {
		try {
		      List<Usuario> alq = usuarioServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarUser/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id){
		Optional<Usuario> carData = usuarioServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Usuario>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertUser")
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario){
        try {
        	Usuario _alq = usuarioServiceImpl.create(usuario);
            return new ResponseEntity<Usuario>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteUser/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable("id") int id){
		try {
			usuarioServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidUser/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Usuario usuario){
		Optional<Usuario> carData = usuarioServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Usuario dbequipo = carData.get();
	    	  dbequipo.setNombre_user(usuario.getNombre_user());
	    	  dbequipo.setContraseña(usuario.getContraseña());
	    	  dbequipo.setImg_perfil(usuario.getImg_perfil());

	 
	        
	        return new ResponseEntity<Usuario>(usuarioServiceImpl.update(dbequipo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}