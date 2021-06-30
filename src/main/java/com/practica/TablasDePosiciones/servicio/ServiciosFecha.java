package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.dto.FechaDTO;
import com.practica.TablasDePosiciones.entity.Fecha;

public interface ServiciosFecha {

	List<Fecha> getAll();

	FechaDTO create(FechaDTO fecha);
	
	Fecha read(int id);
	
	Fecha update(Fecha fecha);
	
	void delete(int id);

	List<FechaDTO> getByTorneo(int idTorneo);
}
