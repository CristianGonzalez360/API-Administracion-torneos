package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.TorneoDao;
import com.practica.TablasDePosiciones.entity.Torneo;

@Service
public class ServiciosTorneoImp implements ServiciosTorneo {

	@Autowired
	private TorneoDao dao;
	
	@Override
	public List<Torneo> getAll() {
		List<Torneo> ret = new ArrayList<>();
		for(Torneo torneo:this.dao.findAll()) {
			ret.add(torneo);
		}
		return ret;
	}

	@Override
	public Torneo create(Torneo torneo) {
		return this.dao.save(torneo);
	}

	@Override
	public Torneo read(int id) {
		Optional<Torneo> ret = this.dao.findById(id);
		return ret.get();
	}

	@Override
	public Torneo update(Torneo torneo) {
		return this.dao.save(torneo);
	}

	@Override
	public void delete(int id) {
		Torneo torneo = this.dao.findById(id).get();
		this.dao.delete(torneo);
	}

}
