package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.EquipoDao;
import com.practica.TablasDePosiciones.dao.FechaDao;
import com.practica.TablasDePosiciones.dao.PartidoDao;
import com.practica.TablasDePosiciones.dao.TorneoDao;
import com.practica.TablasDePosiciones.dto.HistorialTorneoDTO;
import com.practica.TablasDePosiciones.dto.TorneoDTO;
import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.EstadoPartido;
import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Partido;
import com.practica.TablasDePosiciones.entity.Torneo;

@Service
public class ServiciosTorneoImp implements ServiciosTorneo {

	@Autowired
	private TorneoDao dao;
	
	@Autowired
	private EquipoDao equipoDao;
	
	@Autowired
	private PartidoDao partidoDao;
	
	@Autowired
	private FechaDao fechaDao;
	
	@Autowired
	private ServiciosTabla serviciosTabla;
	
	@Override
	public List<TorneoDTO> getAll() {
		List<TorneoDTO> ret = new ArrayList<>();
		for(Torneo torneo:this.dao.findAll()) {
			ret.add(new TorneoDTO(torneo));
		}
		return ret;
	}

	@Override
	public Torneo create(Torneo torneo) {
		return this.dao.save(torneo);
	}

	@Override
	public TorneoDTO read(int id) {
		Optional<Torneo> ret = this.dao.findById(id);
		return new TorneoDTO(ret.get());
	}

	@Override
	public Torneo update(Torneo torneo) {
		return this.dao.save(torneo);
	}

	@Override
	public void delete(int id) {
		Torneo torneo = this.dao.findById(id).get();
		for(Fecha fecha : this.fechaDao.findByTorneo(torneo)){
			for(Partido partido : this.partidoDao.findByFecha(fecha)) {
				this.partidoDao.delete(partido);
			}
			this.fechaDao.delete(fecha);
		}
		this.dao.delete(torneo);
	}

	@Override
	public HistorialTorneoDTO getHistorial(int idEquipo, int idTorneo) {
		Torneo torneo = this.dao.findById(idTorneo).get();
		Equipo equipo = this.equipoDao.findById(idEquipo).get();
		List<Partido> partidos = this.partidoDao.findByEquipoAndTorneo(equipo, torneo);
		HistorialTorneoDTO ret = new HistorialTorneoDTO();
		ret.setEquipo(equipo);
		ret.setNombreTorneo(torneo.getNombre());
		ret.setPartidos(partidos);
		ret.setTotales(this.serviciosTabla.calcularTotales(equipo, this.partidoDao.findByEquipoAndTorneoAndEstado(equipo, torneo, EstadoPartido.JUGADO)));
		return ret;
	}

}
