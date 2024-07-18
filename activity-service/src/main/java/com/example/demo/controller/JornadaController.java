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

import com.example.demo.DTO.JornadaDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.client.ChampionsProyectClient;
import com.example.demo.entity.Champions;
import com.example.demo.entity.Disciplina;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Lugar;
import com.example.demo.service.JornadaService;
import com.example.demo.service.DisciplinaService;


@RestController
@RequestMapping("/apijornada")
public class JornadaController {
	@Autowired
	JornadaService jornadaService;
	
	@Autowired
	DisciplinaService discplService ;
	
	@Autowired
	ChampionsProyectClient championsproClient ;
	
	@Autowired
	AcademicClient academicClient ;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Jornada>> listar(){
		List<Jornada> listaJornada =jornadaService.Listar();
		return new ResponseEntity<List<Jornada>>(listaJornada,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Jornada>getById(@PathVariable("id")int id){
		if(!jornadaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Jornada jornada =jornadaService.findById(id).get();
			return new ResponseEntity<Jornada>(jornada,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody JornadaDTO jornadaDTO){
		Optional<Disciplina> disciplina = discplService.findById(jornadaDTO.getIdDisciplina());
		Optional<Lugar> lugar = academicClient.getLugarById(jornadaDTO.getIdLugar());
		Optional<Champions> champions = championsproClient.getChampionsById(jornadaDTO.getIdChampions());
		
		Jornada jornada = new Jornada(jornadaDTO.getFecha(),disciplina.get(),lugar.get(),champions.get(),null);
		jornadaService.save(jornada);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody JornadaDTO jornadaDTO){
		if(!jornadaService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Disciplina> disciplina = discplService.findById(jornadaDTO.getIdDisciplina());
		Optional<Lugar> lugar = academicClient.getLugarById(jornadaDTO.getIdLugar());
		Optional<Champions> champions = championsproClient.getChampionsById(jornadaDTO.getIdChampions());
		
		Jornada jornada = jornadaService.findById(id).get();
		jornada.setFecha(jornadaDTO.getFecha());
		jornada.setDisciplina(disciplina.get());
		jornada.setLugar(lugar.get());
		jornada.setChampions(champions.get());		
		jornadaService.save(jornada);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!jornadaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			jornadaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
