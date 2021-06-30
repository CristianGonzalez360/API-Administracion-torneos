package com.practica.TablasDePosiciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.TablasDePosiciones.dto.Tabla;
import com.practica.TablasDePosiciones.servicio.ServiciosTabla;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/tabla")
public class TablasController {

	@Autowired
	private ServiciosTabla servicios;
	
	@GetMapping("/{idTorneo}")
	public List<Tabla> getTabla(@PathVariable("idTorneo") int idTorneo) {
		return this.servicios.getTablaByTorneo(idTorneo);
	}
}
