package com.practica.TablasDePosiciones.controller;

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

import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.servicio.ServiciosEquipo;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/equipo")
public class EquipoController {

	@Autowired
	private ServiciosEquipo servicios;
	
	@PostMapping
	public Equipo addEquipo(@RequestBody Equipo equipo) {	
		return servicios.create(equipo);
	}
	
	@GetMapping
	public List<Equipo> getAll(){
		return servicios.getAll();
	}
	
	@PutMapping
	public Equipo updateEquipo(@RequestBody Equipo equipo) {
		return this.servicios.update(equipo);
	}
	
	@GetMapping("/{id}")
	public Equipo getById(@PathVariable("id") int id) {
		return this.servicios.read(id);
	}
	
	@DeleteMapping
	public void delete(@PathVariable("id") int id) {
		this.servicios.delete(id);
	}
	
	@GetMapping("/porCategoria/{idCategoria}")
	public List<Equipo> getEquipoByCategoria(@PathVariable("idCategoria") int idCategoria){
		return this.servicios.getEquipoByCategoria(idCategoria);
	}
}
