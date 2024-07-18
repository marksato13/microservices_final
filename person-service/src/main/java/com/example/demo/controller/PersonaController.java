package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/apipersona")
public class PersonaController {
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> listaPersona =personaService.Listar();
		return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Persona>getById(@PathVariable("id")int id){
		if(!personaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Persona persona =personaService.findById(id).get();
			return new ResponseEntity<Persona>(persona,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody PersonaDTO personaDTO){
		Persona persona = new Persona(personaDTO.getNombre(),personaDTO.getApepat(),personaDTO.getApemat(),personaDTO.getDni(),personaDTO.getTelf(),
				personaDTO.getDirec(),personaDTO.getCorreo(),personaDTO.getFechanac(),null,null,null,null);
		personaService.save(persona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody PersonaDTO personaDTO){
		if(!personaService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Persona persona = personaService.findById(id).get();
		persona.setNombre(personaDTO.getNombre());
		persona.setApepat(personaDTO.getApepat());
		persona.setApemat(personaDTO.getApemat());
		persona.setDni(personaDTO.getDni());
		persona.setTelf(personaDTO.getTelf());
		persona.setDirec(personaDTO.getNombre());
		persona.setCorreo(personaDTO.getCorreo());
		persona.setFechanac(personaDTO.getFechanac());
		personaService.save(persona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!personaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
