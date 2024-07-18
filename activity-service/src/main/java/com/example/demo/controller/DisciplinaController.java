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

import com.example.demo.DTO.DisciplinaDTO;
import com.example.demo.entity.Disciplina;
import com.example.demo.service.DisciplinaService;

@RestController
@RequestMapping("/apidisciplina")
public class DisciplinaController {
	
	@Autowired
	DisciplinaService discplService ;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Disciplina>> listar(){
		List<Disciplina> listaDiscpl =discplService.Listar();
		return new ResponseEntity<List<Disciplina>>(listaDiscpl,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Disciplina>getById(@PathVariable("id")int id){
		if(!discplService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Disciplina discpl =discplService.findById(id).get();
			return new ResponseEntity<Disciplina>(discpl,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody DisciplinaDTO disciplinaDTO){
		
		Disciplina discpl = new Disciplina(disciplinaDTO.getNombredis(),null);
		discplService.save(discpl);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody DisciplinaDTO disciplinaDTO){
		if(!discplService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Disciplina discpl = discplService.findById(id).get();
		discpl.setNombredis(disciplinaDTO.getNombredis());	
		discplService.save(discpl);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!discplService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			discplService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
