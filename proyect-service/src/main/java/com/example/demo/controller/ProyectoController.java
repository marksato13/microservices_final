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

import com.example.demo.DTO.ProyectoDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.entity.Escuela;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Semestre;
import com.example.demo.entity.TipoPro;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.service.ProyectoService;
import com.example.demo.service.TipoProService;


@RestController
@RequestMapping("/apiproyecto")
public class ProyectoController {
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	TipoProService tipoproService;
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	
	@Autowired
	AcademicClient academicClient;
	
	@GetMapping("/listarp")
	public ResponseEntity<List<Proyecto>> listar(){
		List<Proyecto> listaProyecto =proyectoService.Listar();
		return new ResponseEntity<List<Proyecto>>(listaProyecto, HttpStatus.OK);
	}
	
	
	 @GetMapping("/filtrarPorSemestre/{idSemestre}")
	    public ResponseEntity<List<Proyecto>> getProyectosBySemestre(@PathVariable int idSemestre){
	        List<Proyecto> proyectos = proyectoService.findBySemestre(idSemestre);
	        return new ResponseEntity<>(proyectos, HttpStatus.OK);
	    }
	 
	    @GetMapping("/filtrarPorTipoProyecto/{idTipoPro}")
	    public ResponseEntity<List<Proyecto>> getProyectosByTipoProyecto(@PathVariable int idTipoPro){
	        List<Proyecto> proyectos = proyectoService.findByTipoPro(idTipoPro);
	        return new ResponseEntity<>(proyectos, HttpStatus.OK);
	    }


	    @GetMapping("/filtrar/{idSemestre}/{idTipoPro}")
	    public ResponseEntity<List<Proyecto>> getProyectosBySemestreAndTipoProyecto(@PathVariable int idSemestre, @PathVariable int idTipoPro){
	        List<Proyecto> proyectos = proyectoService.findBySemestreAndTipoPro(idSemestre, idTipoPro);
	        return new ResponseEntity<>(proyectos, HttpStatus.OK);
	    }
	
      
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Proyecto>getById(@PathVariable("id")int id){
		if(!proyectoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Proyecto proyecto =proyectoService.findById(id).get();
			return new ResponseEntity<Proyecto>(proyecto,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ProyectoDTO proyectoDTO){
		Optional<TipoPro> tipopro = tipoproService.findById(proyectoDTO.getIdTipoPro());
		Optional<Semestre> semestre = academicClient.getSemestreById(proyectoDTO.getIdSemestre());
		Optional<Escuela> escuela = academicClient.getEscuelaById(proyectoDTO.getIdEscuela());

		Proyecto proyecto = new Proyecto(proyectoDTO.getNombre(),proyectoDTO.getDescripcion(),proyectoDTO.getFechaini(),proyectoDTO.getFechafin(),
				proyectoDTO.getPpto(),proyectoDTO.getEstadopro(),tipopro.get(),semestre.get(),escuela.get());
		proyectoService.save(proyecto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

    @DeleteMapping("/eliminar/{idProyecto}")
    public ResponseEntity<?> deleteProyecto(@PathVariable int idProyecto) {
        try {
            proyectoRepository.deleteById(idProyecto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
        }
    }
	
	
	@PutMapping("/editar/{idProyecto}")
	public ResponseEntity<?> update(@PathVariable("idProyecto") int idProyecto, @RequestBody ProyectoDTO proyectoDTO){
	    if (!proyectoService.existById(idProyecto)){
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    Optional<TipoPro> tipo = tipoproService.findById(proyectoDTO.getIdTipoPro());
	    Optional<Semestre> semestre = academicClient.getSemestreById(proyectoDTO.getIdSemestre());
	    Optional<Escuela> escuela = academicClient.getEscuelaById(proyectoDTO.getIdEscuela());

	    Proyecto proyecto = proyectoService.findById(idProyecto).get();
	    proyecto.setNombre(proyectoDTO.getNombre());
	    proyecto.setDescripcion(proyectoDTO.getDescripcion());
	    proyecto.setFechaini(proyectoDTO.getFechaini());
	    proyecto.setFechafin(proyectoDTO.getFechafin());
	    proyecto.setPpto(proyectoDTO.getPpto());
	    proyecto.setEstadopro(proyectoDTO.getEstadopro());
	    proyecto.setTipopro(tipo.get());
	    proyecto.setSemestre(semestre.get());
	    proyecto.setEscuela(escuela.get());

	    proyectoService.save(proyecto);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/exist/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable("id") int id) {
	    boolean exists = proyectoService.existById(id);
	    return new ResponseEntity<>(exists, HttpStatus.OK);
	}
	
}
