package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.entity.Partido;

public interface ServiciosPartido {

	List<Partido> getPartidoByFecha(int idFecha);
	
	Partido create(Partido partido);

	Partido update(Partido partido);
	
	void delete(int id);
}
