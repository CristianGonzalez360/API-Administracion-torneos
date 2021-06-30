package com.practica.TablasDePosiciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.TablasDePosiciones.dto.FechaDTO;
import com.practica.TablasDePosiciones.servicio.ServiciosFecha;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/fecha")
public class FechaController {
	
	@Autowired
	private ServiciosFecha sevicios;
	
	@PostMapping
	private FechaDTO addFecha(@RequestBody FechaDTO fecha) {
		return this.sevicios.create(fecha);
	}
	
	@GetMapping("/porTorneo/{idTorneo}")
	private List<FechaDTO> porTorneo (@PathVariable("idTorneo") int idTorneo) {
		return this.sevicios.getByTorneo(idTorneo);
	}
}
