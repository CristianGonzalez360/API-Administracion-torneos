package com.practica.TablasDePosiciones.servicio;

import java.util.List;

import com.practica.TablasDePosiciones.entity.Categoria;

public interface ServiciosCategoria {

	List<Categoria> readAll();

	Categoria read(int id);

	Categoria create(Categoria categoria);

	Categoria update(Categoria categoria);

	void delete(int id);

}