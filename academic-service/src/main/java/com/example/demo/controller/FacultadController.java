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

import com.example.demo.DTO.FacutadDTO;
import com.example.demo.entity.Facultad;
import com.example.demo.service.FacultadService;

@RestController
@RequestMapping("/apifacultad")
public class FacultadController {
	@Autowired
	FacultadService facultadService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Facultad>> listar(){
		List<Facultad> listaFacultad =facultadService.Listar();
		return new ResponseEntity<List<Facultad>>(listaFacultad, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Facultad>getById(@PathVariable("id")int id){
		if(!facultadService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Facultad facultad =facultadService.findById(id).get();
			return new ResponseEntity<Facultad>(facultad,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody FacutadDTO facutadDTO){
		Facultad facultad = new Facultad(facutadDTO.getNombrefac(),null);
		facultadService.save(facultad);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody FacutadDTO facutadDTO){
		if(!facultadService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Facultad facultad = facultadService.findById(id).get();
		facultad.setNombrefac(facutadDTO.getNombrefac());
		facultadService.save(facultad);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!facultadService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			facultadService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
