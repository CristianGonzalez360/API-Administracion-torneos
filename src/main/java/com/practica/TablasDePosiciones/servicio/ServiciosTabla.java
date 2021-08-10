package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.dto.FilaTabla;
import com.practica.TablasDePosiciones.dto.Tabla;
import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.Partido;

public interface ServiciosTabla {

	List<Tabla> getTablaByTorneo(int idTorneo);
	FilaTabla calcularTotales(Equipo equipo, List<Partido> partidos);
}