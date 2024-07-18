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

import com.example.demo.DTO.ParticipacionDTO;
import com.example.demo.entity.Participacion;
import com.example.demo.entity.Partido;
import com.example.demo.entity.Equipo;
import com.example.demo.service.ParticipacionService;
import com.example.demo.service.PartidoService;
import com.example.demo.service.EquipoService;


@RestController
@RequestMapping("apipartic")
public class ParticipacionController {
	
	@Autowired
	ParticipacionService particService;
	
	@Autowired
	PartidoService partidoService;
	
	@Autowired
	EquipoService equipoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Participacion>> listar(){
		List<Participacion> listaPartic = particService.Listar();
		return new ResponseEntity<List<Participacion>>(listaPartic,HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Participacion>getById(@PathVariable("id") int id){
		if(!particService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Participacion partic =particService.findById(id).get();
			return new ResponseEntity<Participacion>(partic,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ParticipacionDTO participacionDTO){
		Optional<Partido> partido = partidoService.findById(participacionDTO.getIdPartido());
		Optional<Equipo> equipo = equipoService.findById(participacionDTO.getIdEquipo());
		
		Participacion partic = new Participacion(participacionDTO.getEstadolov(),partido.get(),equipo.get());
		particService.save(partic);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody ParticipacionDTO participacionDTO){
		if(!particService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Partido> partido = partidoService.findById(participacionDTO.getIdPartido());
		Optional<Equipo> equipo = equipoService.findById(participacionDTO.getIdEquipo());
		
		Participacion partic = particService.findById(id).get();
		partic.setEstadolov(participacionDTO.getEstadolov());
		partic.setPartido(partido.get());
		partic.setEquipo(equipo.get());	
		particService.save(partic);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!particService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			particService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
