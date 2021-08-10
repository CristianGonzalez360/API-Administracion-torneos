package com.practica.TablasDePosiciones.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.EquipoDao;
import com.practica.TablasDePosiciones.dao.FechaDao;
import com.practica.TablasDePosiciones.dao.PartidoDao;
import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Partido;

@Service
public class ServiciosPartidoImp implements ServiciosPartido {

	@Autowired
	private PartidoDao dao;
	
	@Autowired
	private FechaDao fechaDao;
	
	@Autowired EquipoDao equipoDao;
	
	@Override
	public List<Partido> getPartidoByFecha(int idFecha) {
		Fecha fecha = this.fechaDao.findById(idFecha).get();
		return this.dao.findByFecha(fecha);
	}

	@Override
	public Partido create(Partido partido) {
		return this.dao.save(partido);
	}

	@Override
	public Partido update(Partido partido) {
		return this.dao.save(partido);
	}

	@Override
	public void delete(int id) {
		this.dao.deleteById(id);
	}
}
