package com.practica.TablasDePosiciones.dao;

import org.springframework.data.repository.CrudRepository;

import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Torneo;

public interface FechaDao extends CrudRepository<Fecha, Integer> {

	Iterable<Fecha> findByTorneo(Torneo torneo);

}
