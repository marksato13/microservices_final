package com.example.demo.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Lugar;
import com.example.demo.entity.Salon;

@FeignClient(name = "academic-service")
public interface AcademicClient {
	
	@GetMapping("apisalon/detalle/{id}")
    Optional<Salon> getSalonById(@PathVariable("id") int id);
	
	@GetMapping("apilugar/detalle/{id}")
    Optional<Lugar> getLugarById(@PathVariable("id") int id);
}
