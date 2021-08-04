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

import com.practica.TablasDePosiciones.entity.Partido;
import com.practica.TablasDePosiciones.servicio.ServiciosPartido;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/partido")
public class PartidoController {

	@Autowired
	private ServiciosPartido servicios;
	
	@PostMapping
	public Partido add(@RequestBody Partido partido) {
		return this.servicios.create(partido);
	}
		
	@GetMapping("/porFecha/{idFecha}")
	public List<Partido> getPartidosByFecha(@PathVariable("idFecha") int idFecha) {
		return this.servicios.getPartidoByFecha(idFecha);
	}
	
	@PutMapping
	public Partido update(@RequestBody Partido partido) {
		return this.servicios.update(partido);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		this.servicios.delete(id);
	}
}
