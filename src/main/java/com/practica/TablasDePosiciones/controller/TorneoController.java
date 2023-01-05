package com.practica.TablasDePosiciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.TablasDePosiciones.dto.HistorialTorneoDTO;
import com.practica.TablasDePosiciones.dto.TorneoDTO;
import com.practica.TablasDePosiciones.entity.Torneo;
import com.practica.TablasDePosiciones.servicio.ServiciosTorneo;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/torneo")
public class TorneoController {

	@Autowired
	private ServiciosTorneo servicios;
			
	@GetMapping
	public List<TorneoDTO> all(){
		return this.servicios.getAll();
	}
			
	@PostMapping
	public Torneo addTorneo(@RequestBody Torneo torneo){
		return this.servicios.create(torneo);
	}
	
	@GetMapping("/{id}")
	public TorneoDTO getTorneo(@PathVariable("id") int id) {
		return this.servicios.read(id);
	}
	
	@GetMapping("/historialEquipo/{idEquipo}/{idTorneo}")
	public HistorialTorneoDTO getPartidosByEquipoAndTorneo(@PathVariable("idEquipo") int idEquipo,
			@PathVariable("idTorneo") int idTorneo) {
		return this.servicios.getHistorial(idEquipo, idTorneo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTorneo(@PathVariable("id") int id){
		System.out.println("borrando Torneo: " + id);
		this.servicios.delete(id);
	}
}
