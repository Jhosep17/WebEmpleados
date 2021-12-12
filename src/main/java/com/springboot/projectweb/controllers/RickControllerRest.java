package com.springboot.projectweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RickControllerRest {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/rick")
	public Object getRestApi() {
		String url = "https://rickandmortyapi.com/api/character";
		return restTemplate.getForObject(url, Object.class);
	}
	
	@GetMapping("/rick/{id}")
	public Object getRestApi(@PathVariable Integer id) {
		String url = "https://rickandmortyapi.com/api/character/"+id;
		return restTemplate.getForObject(url, Object.class);
	}

}
