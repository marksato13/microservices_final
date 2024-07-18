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

import com.example.demo.DTO.AlumnoDTO;
import com.example.demo.entity.Alumno;
import com.example.demo.entity.Salon;
import com.example.demo.entity.Persona;
import com.example.demo.service.AlumnoService;
import com.example.demo.service.PersonaService;
import com.example.demo.client.AcademicClient;


@RestController
@RequestMapping("/apialumno")
public class AlumnoController {
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	AcademicClient academicClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Alumno>> listar(){
		List<Alumno> listaAlumno =alumnoService.Listar();
		return new ResponseEntity<List<Alumno>>(listaAlumno, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Alumno>getById(@PathVariable("id")int id){
		if(!alumnoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Alumno alumno =alumnoService.findById(id).get();
			return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody AlumnoDTO  alumnoDTO){
		Optional<Persona> persona = personaService.findById(alumnoDTO.getIdPersona());
		Optional<Salon> salon = academicClient.getSalonById(alumnoDTO.getIdSalon());

		Alumno alumno = new Alumno(alumnoDTO.getCodigoalum(),persona.get(),salon.get());
		alumnoService.save(alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody AlumnoDTO  alumnoDTO){
		if(!alumnoService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Persona> persona = personaService.findById(alumnoDTO.getIdPersona());
		Optional<Salon> salon = academicClient.getSalonById(alumnoDTO.getIdSalon());
		
		Alumno alumno = alumnoService.findById(id).get();
		alumno.setCodigoalum(alumnoDTO.getCodigoalum());
		alumno.setPersona(persona.get());
		alumno.setSalon(salon.get());
		alumnoService.save(alumno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!alumnoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			alumnoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}