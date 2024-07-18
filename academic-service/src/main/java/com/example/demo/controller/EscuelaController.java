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

import com.example.demo.DTO.EscuelaDTO;
import com.example.demo.client.PersonClient;
import com.example.demo.entity.CoordinadorTutoria;
import com.example.demo.entity.DirectorEscuela;
import com.example.demo.entity.Escuela;
import com.example.demo.entity.Facultad;
import com.example.demo.service.EscuelaService;
import com.example.demo.service.FacultadService;

@RestController
@RequestMapping("/apiescuela")
public class EscuelaController {
	@Autowired
	EscuelaService escuelaService;
	
	@Autowired
	FacultadService facultadService ;
	
	@Autowired
	PersonClient personClient ;
	
	@GetMapping("/listare")
	public ResponseEntity<List<Escuela>> listar(){
		List<Escuela> listaEscuela =escuelaService.Listar();
		return new ResponseEntity<List<Escuela>>(listaEscuela,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Escuela>getById(@PathVariable("id")int id){
		if(!escuelaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Escuela escuela =escuelaService.findById(id).get();
			return new ResponseEntity<Escuela>(escuela,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody EscuelaDTO escuelaDTO){
		Optional<Facultad> facultad = facultadService.findById(escuelaDTO.getIdFacultad());
		Optional<CoordinadorTutoria> coordtut = personClient.getCoordTutById(escuelaDTO.getIdCoordtut());
		Optional<DirectorEscuela> diresc = personClient.getDirEscById(escuelaDTO.getIdDiresc());
		
		Escuela escuela = new Escuela(escuelaDTO.getNombresc(),diresc.get(),coordtut.get(),facultad.get());
		escuelaService.save(escuela);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody EscuelaDTO escuelaDTO){
		if(!escuelaService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Facultad> facultad = facultadService.findById(escuelaDTO.getIdFacultad());
		Optional<CoordinadorTutoria> coordtut = personClient.getCoordTutById(escuelaDTO.getIdCoordtut());
		Optional<DirectorEscuela> diresc = personClient.getDirEscById(escuelaDTO.getIdDiresc());
		
		Escuela escuela = escuelaService.findById(id).get();
		escuela.setNombresc(escuelaDTO.getNombresc());
		escuela.setFacultad(facultad.get());
		escuela.setCoordtut(coordtut.get());
		escuela.setDiresc(diresc.get());		
		escuelaService.save(escuela);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!escuelaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			escuelaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
