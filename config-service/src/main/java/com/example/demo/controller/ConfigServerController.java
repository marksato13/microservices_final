package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiserver")
public class ConfigServerController {
	
	@GetMapping("/alta")public String alta(){
		return "servidor levantado!!";
	}
}
