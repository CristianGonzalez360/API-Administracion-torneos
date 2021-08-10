package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.dto.HistorialTorneoDTO;
import com.practica.TablasDePosiciones.dto.TorneoDTO;
import com.practica.TablasDePosiciones.entity.Torneo;

public interface ServiciosTorneo {

	List<TorneoDTO> getAll();

	Torneo create(Torneo torneo);
	
	TorneoDTO read(int id);
	
	Torneo update(Torneo torneo);
	
	void delete(int id);
	
	HistorialTorneoDTO getHistorial(int idEquipo, int idTorneo);
}
