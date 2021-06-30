package com.practica.TablasDePosiciones.dao;

import org.springframework.data.repository.CrudRepository;

import com.practica.TablasDePosiciones.entity.Torneo;

public interface TorneoDao extends CrudRepository<Torneo, Integer> {

}
