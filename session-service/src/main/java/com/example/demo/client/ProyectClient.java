package com.example.demo.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Proyecto;

@FeignClient(name = "proyect-service")
public interface ProyectClient {
	
	@GetMapping("apiproyecto/exist/{id}")
    boolean existproById(@PathVariable("id") int id);
	
	@GetMapping("apiproyecto/detalle/{id}")
    Optional<Proyecto> getProyectoById(@PathVariable("id") int id);

	
}