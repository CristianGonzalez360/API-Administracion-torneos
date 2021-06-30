package com.practica.TablasDePosiciones.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.TablasDePosiciones.entity.Categoria;
import com.practica.TablasDePosiciones.servicio.ServiciosCategoria;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ServiciosCategoria servicios;
	
	@PostMapping
	public Categoria addCategoria(@RequestBody Categoria categoria) {	
		return servicios.create(categoria);	
	}
	
	@GetMapping
	public List<Categoria> getAll(){
		List<Categoria> ret = new ArrayList<>();
		for(Categoria categoria : servicios.readAll()) {
			ret.add(categoria);
		}
		return ret;
	}
	
	@PutMapping
	public Categoria updateCategoria(@RequestBody Categoria categoria) {
		return servicios.update(categoria);
	}
	
	@GetMapping("/{id}")
	public Categoria getById(@PathVariable("id") int id) {
		return servicios.read(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		this.servicios.delete(id);
	}
}
