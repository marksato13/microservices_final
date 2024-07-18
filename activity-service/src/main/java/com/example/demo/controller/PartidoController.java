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

import com.example.demo.DTO.PartidoDTO;
import com.example.demo.entity.Partido;
import com.example.demo.entity.Jornada;
import com.example.demo.service.PartidoService;
import com.example.demo.service.JornadaService;


@RestController
@RequestMapping("/apipartido")
public class PartidoController {
	@Autowired
	PartidoService partidoService;
		
	@Autowired
	JornadaService jornadaService ;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Partido>> listar(){
		List<Partido> listaPartido =partidoService.Listar();
		return new ResponseEntity<List<Partido>>(listaPartido,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Partido>getById(@PathVariable("id")int id){
		if(!partidoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Partido partido =partidoService.findById(id).get();
			return new ResponseEntity<Partido>(partido,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody PartidoDTO partidoDTO){
		Optional<Jornada> jornada = jornadaService.findById(partidoDTO.getIdJornada());
		
		Partido partido = new Partido(partidoDTO.getHora(),jornada.get(),null,null);
		partidoService.save(partido);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody PartidoDTO partidoDTO){
		if(!partidoService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Jornada> jornada = jornadaService.findById(partidoDTO.getIdJornada());
		
		Partido partido = partidoService.findById(id).get();
		partido.setHora(partidoDTO.getHora());
		partido.setJornada(jornada.get());		
		partidoService.save(partido);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!partidoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			partidoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
