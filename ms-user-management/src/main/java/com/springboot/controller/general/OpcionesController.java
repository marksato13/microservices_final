package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Opciones;
import com.springboot.serviceImpl.OpcionesServiceImpl;

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

import static com.springboot.commons.GlobalConstans.API_OPCIONES;

@RestController
@RequestMapping(API_OPCIONES)
@CrossOrigin({"*"})

public class OpcionesController {
	@Autowired
	private OpcionesServiceImpl opcionesServiceImpl;
	
	
	@GetMapping("/ListOpci")
	public ResponseEntity<List<Opciones>> listar() {
		try {
		      List<Opciones> alq = opcionesServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarOpci/{id}")
	public ResponseEntity<Opciones> getOpcionesById(@PathVariable("id") int id){
		Optional<Opciones> carData = opcionesServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Opciones>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertOpci")
    public ResponseEntity<Opciones> crear(@Valid @RequestBody Opciones opciones){
        try {
        	Opciones _alq = opcionesServiceImpl.create(opciones);
            return new ResponseEntity<Opciones>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteOpci/{id}")
	public ResponseEntity<Opciones> delete(@PathVariable("id") int id){
		try {
			opcionesServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidOpci/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Opciones opciones){
		Optional<Opciones> carData = opcionesServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Opciones dbequipo = carData.get();
	    	  dbequipo.setRuta_accesos(opciones.getRuta_accesos());
	 
	        
	        return new ResponseEntity<Opciones>(opcionesServiceImpl.update(dbequipo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}