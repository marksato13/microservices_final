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

import com.example.demo.DTO.EquipoDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.entity.Equipo;
import com.example.demo.entity.Salon;
import com.example.demo.service.EquipoService;

@RestController
@RequestMapping("/apiequipo")
public class EquipoController {
	@Autowired
	EquipoService equipoService;
		
	@Autowired
	AcademicClient academicClient ;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Equipo>> listar(){
		List<Equipo> listaEquipo =equipoService.Listar();
		return new ResponseEntity<List<Equipo>>(listaEquipo,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Equipo>getById(@PathVariable("id")int id){
		if(!equipoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Equipo equipo =equipoService.findById(id).get();
			return new ResponseEntity<Equipo>(equipo,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody EquipoDTO equipoDTO){
		Optional<Salon> salon = academicClient.getSalonById(equipoDTO.getIdSalon());
		
		Equipo equipo = new Equipo(equipoDTO.getNombrequi(),salon.get(),null);
		equipoService.save(equipo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody EquipoDTO equipoDTO){
		if(!equipoService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Salon> salon = academicClient.getSalonById(equipoDTO.getIdSalon());
		
		Equipo equipo = equipoService.findById(id).get();
		equipo.setNombrequi(equipoDTO.getNombrequi());
		equipo.setSalon(salon.get());		
		equipoService.save(equipo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!equipoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			equipoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
