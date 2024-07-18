package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Usuario_Rol;
import com.springboot.serviceImpl.Usuario_RolServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
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

import static com.springboot.commons.GlobalConstans.API_USUARIOROL;

@RestController
@RequestMapping(API_USUARIOROL)
@CrossOrigin({"*"})

public class Usuario_RolController {
	@Autowired
	private Usuario_RolServiceImpl usuario_RolServiceImpl;
	
	
	@GetMapping("/ListUsR")
	public ResponseEntity<List<Usuario_Rol>> listar() {
		try {
		      List<Usuario_Rol> alq = usuario_RolServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarUsR/{id}")
	public ResponseEntity<Usuario_Rol> getUsuario_RolById(@PathVariable("id") int id){
		Optional<Usuario_Rol> carData = usuario_RolServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Usuario_Rol>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertUsR")
    public ResponseEntity<Usuario_Rol> crear(@Valid @RequestBody Usuario_Rol usuario_Rol){
        try {
        	Usuario_Rol _alq = usuario_RolServiceImpl.create(usuario_Rol);
            return new ResponseEntity<Usuario_Rol>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteUsR/{id}")
	public ResponseEntity<Usuario_Rol> delete(@PathVariable("id") int id){
		try {
			usuario_RolServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidUsR/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Usuario_Rol usuario_Rol){
		Optional<Usuario_Rol> carData = usuario_RolServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Usuario_Rol dbusuario_Rol = carData.get();
	 
	        
	        return new ResponseEntity<Usuario_Rol>(usuario_RolServiceImpl.update(dbusuario_Rol), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}