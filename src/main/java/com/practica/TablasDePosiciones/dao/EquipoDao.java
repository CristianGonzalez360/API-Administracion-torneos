package com.practica.TablasDePosiciones.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practica.TablasDePosiciones.entity.Categoria;
import com.practica.TablasDePosiciones.entity.Equipo;

public interface EquipoDao extends CrudRepository<Equipo, Integer> {

	public List<Equipo> findByCategoria(Categoria categoria);
}
