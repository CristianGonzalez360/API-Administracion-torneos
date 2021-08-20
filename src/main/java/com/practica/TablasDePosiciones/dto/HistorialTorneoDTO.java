package com.practica.TablasDePosiciones.dto;

import java.util.List;

import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.Partido;

public class HistorialTorneoDTO {

	private Equipo equipo;
	private String nombreTorneo; 
	private List<Partido> partidos;
	private FilaTabla totales;
	
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public List<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	public FilaTabla getTotales() {
		return totales;
	}
	public void setTotales(FilaTabla totales) {
		this.totales = totales;
	}
	
	
}
