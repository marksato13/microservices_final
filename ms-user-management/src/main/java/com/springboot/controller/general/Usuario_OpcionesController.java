//package com.springboot.controller.general;
//
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.entity.Usuario_Opciones;
//import com.springboot.serviceImpl.Usuario_OpcionesServiceImpl;
//
//import jakarta.validation.Valid;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import static com.springboot.commons.GlobalConstans.API_USUARIOOPCIONES;
//
//@RestController
//@RequestMapping(API_USUARIOOPCIONES)
//@CrossOrigin({"*"})
//
//public class Usuario_OpcionesController {
//	@Autowired
//	private Usuario_OpcionesServiceImpl usuario_OpcionesServiceImpl;
//	
//	
//	@GetMapping("/ListUsO")
//	public ResponseEntity<List<Usuario_Opciones>> listar() {
//		try {
//		      List<Usuario_Opciones> alq = usuario_OpcionesServiceImpl.readAll();
//		      if (alq.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//		      return new ResponseEntity<>(alq, HttpStatus.OK);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//	}
//	
//	
//	@GetMapping("BuscarUsO/{id}")
//	public ResponseEntity<Usuario_Opciones> getUsuario_OpcionesById(@PathVariable("id") int id){
//		Optional<Usuario_Opciones> carData = usuario_OpcionesServiceImpl.read(id);
//	    if (carData.isPresent()) {
//	      return new ResponseEntity<Usuario_Opciones>(carData.get(), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	
//	@PostMapping("/InsertUsO")
//    public ResponseEntity<Usuario_Opciones> crear(@Valid @RequestBody Usuario_Opciones usuario_Opciones){
//        try {
//        	Usuario_Opciones _alq = usuario_OpcionesServiceImpl.create(usuario_Opciones);
//            return new ResponseEntity<Usuario_Opciones>(_alq, HttpStatus.CREATED);
//          } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//          }
//    }
//	
//
//	@DeleteMapping("DeleteUsO/{id}")
//	public ResponseEntity<Usuario_Opciones> delete(@PathVariable("id") int id){
//		try {
//			usuario_OpcionesServiceImpl.delete(id);
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	      } catch (Exception e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	      }
//	}
//	
//	
//	@PutMapping("EdidUsO/{id}")
//	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Usuario_Opciones usuario_Opciones){
//		Optional<Usuario_Opciones> carData = usuario_OpcionesServiceImpl.read(id);
//	      if (carData.isPresent()) {
//	    	  Usuario_Opciones dbusuario_Opciones = carData.get();
//	 
//	        
//	        return new ResponseEntity<Usuario_Opciones>(usuario_OpcionesServiceImpl.update(dbusuario_Opciones), HttpStatus.OK);
//	      } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	      }
//	}
//}