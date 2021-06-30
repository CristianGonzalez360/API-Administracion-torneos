package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.FechaDao;
import com.practica.TablasDePosiciones.dao.TorneoDao;
import com.practica.TablasDePosiciones.dto.FechaDTO;
import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Torneo;

@Service
public class ServiciosFechaImp implements ServiciosFecha {

	@Autowired
	private FechaDao dao;
	
	@Autowired 
	private TorneoDao torneoDao;
	
	@Override
	public List<Fecha> getAll() {
		List<Fecha> ret = new ArrayList<>();
		for(Fecha fecha:this.dao.findAll()) {
			ret.add(fecha);
		}
		return ret;
	}

	@Override
	public FechaDTO create(FechaDTO fecha) {
		Fecha nueva = new Fecha();
		nueva.setId(fecha.getId());
		nueva.setNumero(fecha.getNumero());
		nueva.setTorneo(this.torneoDao.findById(fecha.getIdTorneo()).get());
		Fecha ret = this.dao.save(nueva);
		fecha.setId(ret.getId());
		return fecha;
	}

	@Override
	public Fecha read(int id) {
		return this.dao.findById(id).get();
	}

	@Override
	public Fecha update(Fecha fecha) {
		return this.dao.save(fecha);
	}

	@Override
	public void delete(int id) {
		this.dao.deleteById(id);
	}

	@Override
	public List<FechaDTO> getByTorneo(int idTorneo) {
		Torneo torneo = this.torneoDao.findById(idTorneo).get();
		List<FechaDTO> ret = new ArrayList<>();
		for(Fecha fecha : this.dao.findByTorneo(torneo)) {
			FechaDTO dto = new FechaDTO(fecha.getId(), fecha.getNumero(), idTorneo);
			ret.add(dto);
		}
		return ret;
	}

}
