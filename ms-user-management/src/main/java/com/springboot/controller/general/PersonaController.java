package com.springboot.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Persona;
import com.springboot.serviceImpl.PersonaServiceImpl;

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

import static com.springboot.commons.GlobalConstans.API_PERSONA;

@RestController
@RequestMapping(API_PERSONA)
@CrossOrigin({"*"})
public class PersonaController {
	@Autowired
	private PersonaServiceImpl personaServiceImpl;
	
	
	@GetMapping("/ListPer")
	public ResponseEntity<List<Persona>> listar() {
		try {
		      List<Persona> alq = personaServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      e.printStackTrace();
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarPer/{id}")
	public ResponseEntity<Persona> getTipo_ConvenioById(@PathVariable("id") int id){
		Optional<Persona> carData = personaServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Persona>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertPerC")
    public ResponseEntity<Persona> crear(@Valid @RequestBody Persona persona){
        try {
        	Persona _alq = personaServiceImpl.create(persona);
            return new ResponseEntity<Persona>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeletePer/{id}")
	public ResponseEntity<Persona> delete(@PathVariable("id") int id){
		try {
			personaServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidPer/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Persona persona){
		Optional<Persona> carData = personaServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Persona dbtipo_Convenio = carData.get();
	    	  dbtipo_Convenio.setNombre(persona.getNombre());
	    	  dbtipo_Convenio.setApellido(persona.getApellido());
	    	  dbtipo_Convenio.setDni(persona.getDni());
	    	  dbtipo_Convenio.setTelefono(persona.getTelefono());
	    	  dbtipo_Convenio.setCorreo(persona.getCorreo());

	        
	        return new ResponseEntity<Persona>(personaServiceImpl.update(dbtipo_Convenio), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}