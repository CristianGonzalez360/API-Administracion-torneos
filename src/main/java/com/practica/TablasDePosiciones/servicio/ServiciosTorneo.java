package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.entity.Torneo;

public interface ServiciosTorneo {

	List<Torneo> getAll();

	Torneo create(Torneo torneo);
	
	Torneo read(int id);
	
	Torneo update(Torneo torneo);
	
	void delete(int id);
}
