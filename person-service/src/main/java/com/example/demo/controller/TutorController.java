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

import com.example.demo.DTO.TutorDTO;
import com.example.demo.entity.Tutor;
import com.example.demo.entity.Escuela;
import com.example.demo.entity.Persona;
import com.example.demo.service.TutorService;
import com.example.demo.service.PersonaService;
import com.example.demo.client.AcademicClient;


@RestController
@RequestMapping("/apitutor")
public class TutorController {
	@Autowired
	TutorService tutorService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	AcademicClient academicClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Tutor>> listar(){
		List<Tutor> listaTutor =tutorService.Listar();
		return new ResponseEntity<List<Tutor>>(listaTutor, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Tutor>getById(@PathVariable("id")int id){
		if(!tutorService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Tutor tutor =tutorService.findById(id).get();
			return new ResponseEntity<Tutor>(tutor,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody TutorDTO tutorDTO){
		Optional<Persona> persona = personaService.findById(tutorDTO.getIdPersona());
		Optional<Escuela> escuela = academicClient.getEscuelaById(tutorDTO.getIdEscuela());

		Tutor tutor = new Tutor(tutorDTO.getCodigotut(),escuela.get(),persona.get());
		tutorService.save(tutor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody TutorDTO tutorDTO){
		if(!tutorService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Persona> persona = personaService.findById(tutorDTO.getIdPersona());
		Optional<Escuela> escuela = academicClient.getEscuelaById(tutorDTO.getIdEscuela());
		
		Tutor tutor = tutorService.findById(id).get();
		tutor.setCodigotut(tutorDTO.getCodigotut());
		tutor.setPersona(persona.get());
		tutor.setEscuela(escuela.get());
		tutorService.save(tutor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!tutorService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			tutorService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}