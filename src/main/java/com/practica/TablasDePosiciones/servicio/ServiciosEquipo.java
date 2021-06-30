package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.entity.Equipo;

public interface ServiciosEquipo {

	List<Equipo> getAll();

	Equipo create(Equipo equipo);
	
	Equipo read(int id);
	
	Equipo update(Equipo equipo);
	
	void delete(int id);

	List<Equipo> getEquipoByCategoria(int idCategoria);

}