package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Rol_Opciones;
import com.springboot.serviceImpl.Rol_OpcionesServiceImpl;

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

import static com.springboot.commons.GlobalConstans.API_ROLOPCIONES;

@RestController
@RequestMapping(API_ROLOPCIONES)
@CrossOrigin({"*"})

public class Rol_OpcionesController {
	@Autowired
	private Rol_OpcionesServiceImpl rol_OpcionesServiceImpl;
	
	
	@GetMapping("/ListRolopc")
	public ResponseEntity<List<Rol_Opciones>> listar() {
		try {
		      List<Rol_Opciones> alq = rol_OpcionesServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarRolopc/{id}")
	public ResponseEntity<Rol_Opciones> getRol_OpcionesById(@PathVariable("id") int id){
		Optional<Rol_Opciones> carData = rol_OpcionesServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Rol_Opciones>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertRolopc")
    public ResponseEntity<Rol_Opciones> crear(@Valid @RequestBody Rol_Opciones rolopc){
        try {
        	Rol_Opciones _alq = rol_OpcionesServiceImpl.create(rolopc);
            return new ResponseEntity<Rol_Opciones>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteRolopc/{id}")
	public ResponseEntity<Rol_Opciones> delete(@PathVariable("id") int id){
		try {
			rol_OpcionesServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidRolopc/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Rol_Opciones rolopc){
		Optional<Rol_Opciones> carData = rol_OpcionesServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Rol_Opciones dbrolopc = carData.get();
	 
	        
	        return new ResponseEntity<Rol_Opciones>(rol_OpcionesServiceImpl.update(dbrolopc), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}