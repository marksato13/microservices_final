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

import com.example.demo.DTO.CicloDTO;
import com.example.demo.entity.Ciclo;
import com.example.demo.service.CicloService;

@RestController
@RequestMapping("/apiciclo")
public class CicloController {
	@Autowired
	CicloService cicloService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Ciclo>> listar(){
		List<Ciclo> listaCiclo =cicloService.Listar();
		return new ResponseEntity<List<Ciclo>>(listaCiclo, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Ciclo>getById(@PathVariable("id")int id){
		if(!cicloService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Ciclo ciclo =cicloService.findById(id).get();
			return new ResponseEntity<Ciclo>(ciclo,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody CicloDTO cicloDTO){
		Ciclo ciclo = new Ciclo(cicloDTO.getCiclo(),null);
		cicloService.save(ciclo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody CicloDTO cicloDTO){
		if(!cicloService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Ciclo ciclo = cicloService.findById(id).get();
		ciclo.setCiclo(cicloDTO.getCiclo());
		cicloService.save(ciclo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!cicloService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			cicloService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
