package com.practica.TablasDePosiciones.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.TablasDePosiciones.dao.FechaDao;
import com.practica.TablasDePosiciones.dao.PartidoDao;
import com.practica.TablasDePosiciones.dao.TorneoDao;
import com.practica.TablasDePosiciones.dto.FilaTabla;
import com.practica.TablasDePosiciones.dto.Tabla;
import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.Fecha;
import com.practica.TablasDePosiciones.entity.Grupo;
import com.practica.TablasDePosiciones.entity.Partido;
import com.practica.TablasDePosiciones.entity.Torneo;

@Service
public class ServiciosTablaImp implements ServiciosTabla {

	@Autowired
	private TorneoDao torneoDao;

	@Autowired
	private FechaDao fechaDao;

	@Autowired
	private PartidoDao partidoDao;

	@Override
	public List<Tabla> getTablaByTorneo(int idTorneo) {
		Torneo torneo = this.torneoDao.findById(idTorneo).get();

		List<Tabla> ret = new ArrayList<>();

		List<Partido> partidos = getPartidosByTorneo(torneo);
		
		for (Grupo grupo : torneo.getGrupos()) {
			Tabla tabla = new Tabla(grupo);
			for (Equipo equipo : grupo.getEquipos()) {
				tabla.addEquipo(makeEquipoTabla(equipo, partidos));
			}
			tabla.ordenar();
			ret.add(tabla);
		}
		Collections.sort(ret);
		return ret;
	}

	private List<Partido> getPartidosByTorneo(Torneo torneo) {
		List<Partido> ret = new ArrayList<>();
		for (Fecha fecha : fechaDao.findByTorneo(torneo)) {
			ret.addAll(this.partidoDao.findByFecha(fecha));
		}
		return ret;
	}

	private FilaTabla makeEquipoTabla(Equipo equipo, List<Partido> partidos) {
		FilaTabla ret = new FilaTabla(equipo);
		for (Partido partido : partidos) {
			if (partido.gano(equipo)) {
				ret.ganado();
			} else if (partido.perdio(equipo)) {
				ret.perdido();
			} else if (partido.empato(equipo)) {
				ret.empate();
			}
			ret.goles(partido.getGolesAFavor(equipo), partido.getGolesEnContra(equipo));
		}
		return ret;
	}

}
