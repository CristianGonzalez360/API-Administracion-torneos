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
import com.practica.TablasDePosiciones.entity.EstadoPartido;
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
			ret.add(tablaPorGrupo(grupo, partidos));
		}
		Collections.sort(ret);
		return ret;
	}

	private List<Partido> getPartidosByTorneo(Torneo torneo) {
		List<Partido> ret = new ArrayList<>();
		for (Fecha fecha : fechaDao.findByTorneo(torneo)) {
			ret.addAll(this.partidoDao.findByFechaAndEstado(fecha,EstadoPartido.JUGADO));
		}
		return ret;
	}
	
	private Tabla tablaPorGrupo(Grupo grupo, List<Partido> partidos) {
		Tabla ret = new Tabla(grupo);
		for (Equipo equipo : grupo.getEquipos()) {
			ret.addFila(calcularTotales(equipo, partidos));
		}
		ret.ordenar();
		return ret;
	}

	public FilaTabla calcularTotales(Equipo equipo, List<Partido> partidos) {
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
