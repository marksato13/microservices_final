package com.example.demo.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.CoordinadorTutoria;
import com.example.demo.entity.DirectorEscuela;
import com.example.demo.entity.Tutor;

@FeignClient(name = "person-service")
public interface PersonClient {
	
	@GetMapping("apicoordtut/detalle/{id}")
    Optional<CoordinadorTutoria> getCoordTutById(@PathVariable("id") int id);
	
	@GetMapping("apidiresc/detalle/{id}")
	Optional<DirectorEscuela> getDirEscById(@PathVariable("id") int id);
	
	@GetMapping("apitutor/detalle/{id}")
	Optional<Tutor> getTutorById(@PathVariable("id") int id);
}