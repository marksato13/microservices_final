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

import com.example.demo.DTO.ResultadoDTO;
import com.example.demo.entity.Resultado;
import com.example.demo.entity.Partido;
import com.example.demo.service.ResultadoService;
import com.example.demo.service.PartidoService;


@RestController
@RequestMapping("/apiresultado")
public class ResultadoController {
	
	@Autowired
	ResultadoService resultService ;
	
	@Autowired
	PartidoService partidoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Resultado>> listar(){
		List<Resultado> listaResultado =resultService.Listar();
		return new ResponseEntity<List<Resultado>>(listaResultado,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Resultado>getById(@PathVariable("id")int id){
		if(!resultService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Resultado result =resultService.findById(id).get();
			return new ResponseEntity<Resultado>(result,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ResultadoDTO resultadoDTO){
		Optional<Partido> partido = partidoService.findById(resultadoDTO.getIdPartido());
		
		Resultado result = new Resultado(resultadoDTO.getPtsl(),resultadoDTO.getPtsv(),partido.get());
		resultService.save(result);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody ResultadoDTO resultadoDTO){
		if(!resultService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Partido> partido = partidoService.findById(resultadoDTO.getIdPartido());
		
		Resultado result = resultService.findById(id).get();
		result.setPtsl(resultadoDTO.getPtsl());
		result.setPtsv(resultadoDTO.getPtsv());
		result.setPartido(partido.get());		
		resultService.save(result);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!resultService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			resultService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
