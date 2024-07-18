package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ChampionsDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.entity.Champions;
import com.example.demo.entity.Semestre;
import com.example.demo.service.ChampionsService;


@RestController
@RequestMapping("/apichampions")
public class ChampionsController {
	@Autowired
	ChampionsService championsService;
	
	@Autowired
	AcademicClient academicClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Champions>> listar(){
		List<Champions> listaChampions =championsService.Listar();
		return new ResponseEntity<List<Champions>>(listaChampions, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Champions>getById(@PathVariable("id")int id){
		if(!championsService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Champions champions =championsService.findById(id).get();
			return new ResponseEntity<Champions>(champions,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ChampionsDTO championsDTO){
		Optional<Semestre> semestre = academicClient.getSemestreById(championsDTO.getIdSemestre());

		Champions champions = new Champions(championsDTO.getNombrech(),championsDTO.getFechaini(),championsDTO.getFechafin(),
				championsDTO.getEncargado(),championsDTO.getEstadoch(),semestre.get());
		championsService.save(champions);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody ChampionsDTO championsDTO){
		if(!championsService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	    Optional<Semestre> semestre = academicClient.getSemestreById(championsDTO.getIdSemestre());
		
	    Champions champions = championsService.findById(id).get();
	    champions.setNombrech(championsDTO.getNombrech());
	    champions.setFechaini(championsDTO.getFechaini());
	    champions.setFechafin(championsDTO.getFechafin());
	    champions.setEncargado(championsDTO.getEncargado());
	    champions.setEstadoch(championsDTO.getEstadoch());
	    champions.setSemestre(semestre.get());
	    championsService.save(champions);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!championsService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			championsService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
	
	@GetMapping("/exist/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable("id") int id) {
	    boolean exists = championsService.existById(id);
	    return new ResponseEntity<>(exists, HttpStatus.OK);
	}
}
