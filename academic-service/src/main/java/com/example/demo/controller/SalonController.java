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

import com.example.demo.DTO.SalonDTO;
import com.example.demo.client.PersonClient;
import com.example.demo.entity.Salon;
import com.example.demo.entity.Ciclo;
import com.example.demo.entity.Tutor;
import com.example.demo.service.CicloService;
import com.example.demo.service.SalonService;


@RestController
@RequestMapping("/apisalon")
public class SalonController {
	@Autowired
	SalonService salonService;
	
	@Autowired
	CicloService cicloService;
	
	@Autowired
	PersonClient personClient ;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Salon>> listar(){
		List<Salon> listaSalon =salonService.Listar();
		return new ResponseEntity<List<Salon>>(listaSalon,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Salon>getById(@PathVariable("id")int id){
		if(!salonService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Salon salon =salonService.findById(id).get();
			return new ResponseEntity<Salon>(salon,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody SalonDTO salonDTO){
		Optional<Ciclo> ciclo = cicloService.findById(salonDTO.getIdCiclo());
		Optional<Tutor> tutor = personClient.getTutorById(salonDTO.getIdTutor());
		
		Salon salon = new Salon(salonDTO.getGrupo(),ciclo.get(),tutor.get());
		salonService.save(salon);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody SalonDTO salonDTO){
		if(!salonService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Ciclo> ciclo = cicloService.findById(salonDTO.getIdCiclo());
		Optional<Tutor> tutor = personClient.getTutorById(salonDTO.getIdTutor());
		
		Salon salon = salonService.findById(id).get();
		salon.setGrupo(salonDTO.getGrupo());
		salon.setCiclo(ciclo.get());
		salon.setTutor(tutor.get());
		salonService.save(salon);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!salonService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			salonService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
