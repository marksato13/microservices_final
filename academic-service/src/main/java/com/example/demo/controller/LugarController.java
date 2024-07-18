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

import com.example.demo.DTO.LugarDTO;
import com.example.demo.entity.Lugar;
import com.example.demo.service.LugarService;

@RestController
@RequestMapping("/apilugar")
public class LugarController {
	@Autowired
	LugarService lugarService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Lugar>> listar(){
		List<Lugar> listaLugar =lugarService.Listar();
		return new ResponseEntity<List<Lugar>>(listaLugar, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Lugar>getById(@PathVariable("id")int id){
		if(!lugarService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Lugar lugar =lugarService.findById(id).get();
			return new ResponseEntity<Lugar>(lugar,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody LugarDTO lugarDTO){
		Lugar lugar = new Lugar(lugarDTO.getNombrelug());
		lugarService.save(lugar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody LugarDTO lugarDTO){
		if(!lugarService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Lugar lugar = lugarService.findById(id).get();
		lugar.setNombrelug(lugarDTO.getNombrelug());
		lugarService.save(lugar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!lugarService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			lugarService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}	
	}
}
