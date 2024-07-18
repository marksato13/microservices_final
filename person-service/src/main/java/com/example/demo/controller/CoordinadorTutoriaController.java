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

import com.example.demo.DTO.CoordinadorTutoriaDTO;
import com.example.demo.entity.CoordinadorTutoria;
import com.example.demo.entity.Persona;
import com.example.demo.service.CoordinadorTutoriaService;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/apicoordtut")
public class CoordinadorTutoriaController {
	@Autowired
	CoordinadorTutoriaService coordtutService;
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<CoordinadorTutoria>> listar(){
		List<CoordinadorTutoria> listaCoordtut =coordtutService.Listar();
		return new ResponseEntity<List<CoordinadorTutoria>>(listaCoordtut, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<CoordinadorTutoria>getById(@PathVariable("id")int id){
		if(!coordtutService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			CoordinadorTutoria coordtut =coordtutService.findById(id).get();
			return new ResponseEntity<CoordinadorTutoria>(coordtut,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody CoordinadorTutoriaDTO  coordtutDTO){
		Optional<Persona> persona = personaService.findById(coordtutDTO.getIdPersona());
		
		CoordinadorTutoria coordtut = new CoordinadorTutoria(coordtutDTO.getCodigocoordtut(),persona.get());
		coordtutService.save(coordtut);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody CoordinadorTutoriaDTO  coordtutDTO){
		if(!coordtutService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Persona> persona = personaService.findById(coordtutDTO.getIdPersona());
		
		CoordinadorTutoria coordtut = coordtutService.findById(id).get();
		coordtut.setCodigocoordtut(coordtutDTO.getCodigocoordtut());
		coordtut.setPersona(persona.get());
		coordtutService.save(coordtut);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!coordtutService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			coordtutService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}