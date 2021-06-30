package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.CategoriaDao;
import com.practica.TablasDePosiciones.dao.EquipoDao;
import com.practica.TablasDePosiciones.entity.Categoria;
import com.practica.TablasDePosiciones.entity.Equipo;

@Service
public class ServiciosEquipoImp implements ServiciosEquipo {

	@Autowired
	private EquipoDao dao;
	
	@Autowired
	private CategoriaDao catDao;
	
	@Override
	public List<Equipo> getAll(){
		List<Equipo> ret = new ArrayList<>();
		for(Equipo equipo: dao.findAll()) {
			ret.add(equipo);
		}
		return ret;
	}
	
	@Override
	public Equipo create(Equipo equipo) {
		return this.dao.save(equipo);
	}

	@Override
	public Equipo read(int id) {
		Optional<Equipo> equipo = this.dao.findById(id);
		return equipo.get();
	}

	@Override
	public Equipo update(Equipo equipo) {
		return this.dao.save(equipo);
	}

	@Override
	public void delete(int id) {
		this.dao.deleteById(id);
	}

	@Override
	public List<Equipo> getEquipoByCategoria(int idCategoria) {
		Optional<Categoria> cat = this.catDao.findById(idCategoria);
		return this.dao.findByCategoria(cat.get());
	}
}
