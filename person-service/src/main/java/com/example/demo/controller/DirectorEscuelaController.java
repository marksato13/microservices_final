package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.DTO.DirectorEscuelaDTO;
import com.example.demo.entity.DirectorEscuela;
import com.example.demo.entity.Persona;
import com.example.demo.service.DirectorEscuelaService;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/apidiresc")
public class DirectorEscuelaController {
	@Autowired
	DirectorEscuelaService direscService;
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<DirectorEscuela>> listar(){
		List<DirectorEscuela> listaDiresc =direscService.Listar();
		return new ResponseEntity<List<DirectorEscuela>>(listaDiresc, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<DirectorEscuela>getById(@PathVariable("id")int id){
		if(!direscService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			DirectorEscuela diresc =direscService.findById(id).get();
			return new ResponseEntity<DirectorEscuela>(diresc,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody DirectorEscuelaDTO  direscDTO){
		Optional<Persona> persona = personaService.findById(direscDTO.getIdPersona());
		
		DirectorEscuela diresc = new DirectorEscuela(direscDTO.getCodigodir(),persona.get());
		direscService.save(diresc);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DirectorEscuelaDTO  direscDTO){
		if(!direscService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Persona> persona = personaService.findById(direscDTO.getIdPersona());
		
		DirectorEscuela diresc = direscService.findById(id).get();
		diresc.setCodigodir(direscDTO.getCodigodir());
		diresc.setPersona(persona.get());
		direscService.save(diresc);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!direscService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			direscService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}