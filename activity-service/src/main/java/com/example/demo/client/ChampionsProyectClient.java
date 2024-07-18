package com.example.demo.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Champions;

@FeignClient(name = "championsproyect-service")
public interface ChampionsProyectClient {
	
	@GetMapping("apichampions/detalle/{id}")
    Optional<Champions> getChampionsById(@PathVariable("id") int id);
		
}
