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

import com.example.demo.DTO.TipoProDTO;
import com.example.demo.entity.TipoPro;
import com.example.demo.service.TipoProService;

@RestController
@RequestMapping("/apitipopro")
public class TipoProController {
	@Autowired
	TipoProService tipoProService;
	
	@GetMapping("/listart")
	public ResponseEntity<List<TipoPro>> listar(){
		List<TipoPro> listaTipopro =tipoProService.Listar();
		return new ResponseEntity<List<TipoPro>>(listaTipopro,HttpStatus.OK);			
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<TipoPro>getById(@PathVariable("id")int id){
		if(!tipoProService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			TipoPro tipopro =tipoProService.findById(id).get();
			return new ResponseEntity<TipoPro>(tipopro,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody TipoProDTO tipoproDTO){
		
		TipoPro tipopro = new TipoPro(tipoproDTO.getTipo(),null);
		tipoProService.save(tipopro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody TipoProDTO tipoproDTO){
		if(!tipoProService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TipoPro tipopro = tipoProService.findById(id).get();
		tipopro.setTipo(tipoproDTO.getTipo());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!tipoProService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			tipoProService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
