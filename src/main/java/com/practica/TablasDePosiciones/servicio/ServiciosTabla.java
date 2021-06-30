package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.dto.Tabla;

public interface ServiciosTabla {

	List<Tabla> getTablaByTorneo(int idTorneo);

}