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

import com.example.demo.DTO.TipoSesDTO;
import com.example.demo.entity.TipoSes;
import com.example.demo.service.TipoSesService;

@RestController
@RequestMapping("/apitiposes")
public class TipoSesController {
	@Autowired
	TipoSesService tipoSesService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<TipoSes>> listar(){
		List<TipoSes> listaTipoSes =tipoSesService.Listar();
		return new ResponseEntity<List<TipoSes>>(listaTipoSes,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<TipoSes>getById(@PathVariable("id")int id){
		if(!tipoSesService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			TipoSes tiposes =tipoSesService.findById(id).get();
			return new ResponseEntity<TipoSes>(tiposes,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody TipoSesDTO tipoSesDTO){
		
		TipoSes tiposes = new TipoSes(tipoSesDTO.getTipo(),null);
		tipoSesService.save(tiposes);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody TipoSesDTO tipoSesDTO){
		if(!tipoSesService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TipoSes tiposes = tipoSesService.findById(id).get();
		tiposes.setTipo(tipoSesDTO.getTipo());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!tipoSesService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			tipoSesService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
