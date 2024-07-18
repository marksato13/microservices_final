package com.example.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import com.example.demo.DTO.SesionDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.client.ProyectClient;
import com.example.demo.entity.Lugar;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Sesion;
import com.example.demo.entity.TipoSes;
import com.example.demo.service.SesionService;
import com.example.demo.service.TipoSesService;

@RestController
@RequestMapping("/apisesion")
public class SesionController {
	@Autowired
	SesionService sesionService;
	
	@Autowired
	TipoSesService tipoSesService;
	
	@Autowired
	AcademicClient academicClient;
	
	@Autowired
	ProyectClient proyectClient;
	
	@GetMapping("/Listsesiones")
	public ResponseEntity<List<Sesion>> listar(){
		List<Sesion> listaSesion =sesionService.Listar();
		return new ResponseEntity<List<Sesion>>(listaSesion,HttpStatus.OK);			
	}
	
	@GetMapping("/S/{idProyecto}")
	public ResponseEntity<List<Sesion>> getHabitacionByTipo(@PathVariable("idProyecto") int idProyecto){
		if (!proyectClient.existproById(idProyecto)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			List<Sesion> listaSesion= sesionService.searchSesionbyPro(idProyecto);
			return new ResponseEntity<List<Sesion>>(listaSesion,HttpStatus.OK);	
		}
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Sesion>getById(@PathVariable("id")int id){
		if(!sesionService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Sesion sesion =sesionService.findById(id).get();
			return new ResponseEntity<Sesion>(sesion,HttpStatus.OK);
		}
	}
	
	@PostMapping("/Insertsesiones")
	public ResponseEntity<?> create(@RequestBody SesionDTO sesionDTO){
		Optional<TipoSes> tiposes = tipoSesService.findById(sesionDTO.getIdTipoSes());
		Optional<Lugar> lugar = academicClient.getLugarById(sesionDTO.getIdLugar());
		Optional<Proyecto> proyecto = proyectClient.getProyectoById(sesionDTO.getIdProyecto());
		
		Sesion sesion = new Sesion(sesionDTO.getNombrese(),sesionDTO.getFecha(),sesionDTO.getEncargado(),sesionDTO.getUrlrec(),tiposes.get(),lugar.get(),
				proyecto.get(),null,null);
		sesionService.save(sesion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/EdidJor/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody SesionDTO sesionDTO){
		if(!sesionService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<TipoSes> tiposes = tipoSesService.findById(sesionDTO.getIdTipoSes());
		Optional<Lugar> lugar = academicClient.getLugarById(sesionDTO.getIdLugar());
		Optional<Proyecto> proyecto = proyectClient.getProyectoById(sesionDTO.getIdProyecto());
		
		Sesion sesion = sesionService.findById(id).get();
		sesion.setNombrese(sesionDTO.getNombrese());
		sesion.setFecha(sesionDTO.getFecha());
		sesion.setEncargado(sesionDTO.getEncargado());
		sesion.setUrlrec(sesionDTO.getUrlrec());
		sesion.setTiposes(tiposes.get());
		sesion.setLugar(lugar.get());
		sesion.setProyecto(proyecto.get());		
		sesionService.save(sesion);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	  @GetMapping("/listSesionesPorProyecto/{idProyecto}")
	    public ResponseEntity<List<Map<String, Object>>> listarSesionesPorProyecto(@PathVariable int idProyecto) {
	        List<Map<String, Object>> sesiones = sesionService.findSesionByProyecto(idProyecto);
	        if (sesiones.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(sesiones);
	        }
	    }
	 
	
	@DeleteMapping("/DeleteJor/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!sesionService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			sesionService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
