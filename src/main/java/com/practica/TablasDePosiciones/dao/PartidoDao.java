package com.practica.TablasDePosiciones.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Partido;
import com.practica.TablasDePosiciones.entity.Torneo;

public interface PartidoDao extends CrudRepository<Partido, Integer> {
	List<Partido> findByFecha(Fecha fecha);
	
	@Query("SELECT p FROM Partido p WHERE (p.local = ?1 OR p.visitante = ?1) AND p.fecha.torneo = ?2")
	List<Partido> findByEquipoAndTorneo(Equipo equipo, Torneo torneo);
}
