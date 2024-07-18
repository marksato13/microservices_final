package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Rol;
import com.springboot.serviceImpl.RolServiceImpl;

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

import static com.springboot.commons.GlobalConstans.API_ROL;

@RestController
@RequestMapping(API_ROL)
@CrossOrigin({"*"})

public class RolController {
	@Autowired
	private RolServiceImpl rolServiceImpl;
	
	
	@GetMapping("/ListRol")
	public ResponseEntity<List<Rol>> listar() {
		try {
		      List<Rol> alq = rolServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarRol/{id}")
	public ResponseEntity<Rol> getRolById(@PathVariable("id") int id){
		Optional<Rol> carData = rolServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Rol>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertRol")
    public ResponseEntity<Rol> crear(@Valid @RequestBody Rol rol){
        try {
        	Rol _alq = rolServiceImpl.create(rol);
            return new ResponseEntity<Rol>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteRol/{id}")
	public ResponseEntity<Rol> delete(@PathVariable("id") int id){
		try {
			rolServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidRol/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Rol rol){
		Optional<Rol> carData = rolServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Rol dbequipo = carData.get();
	    	  dbequipo.setNombre_rol(rol.getNombre_rol());
	 
	        
	        return new ResponseEntity<Rol>(rolServiceImpl.update(dbequipo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}