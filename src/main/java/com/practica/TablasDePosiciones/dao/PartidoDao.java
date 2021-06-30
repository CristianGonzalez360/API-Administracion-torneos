package com.practica.TablasDePosiciones.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Partido;

public interface PartidoDao extends CrudRepository<Partido, Integer> {
	List<Partido> findByFecha(Fecha fecha);
}
