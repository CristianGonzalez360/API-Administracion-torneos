package com.practica.TablasDePosiciones.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.practica.TablasDePosiciones.entity.Grupo;

public class Tabla implements Comparable<Tabla>{
	
	private int idGrupo; 
	private String nombreGrupo;
	private List<FilaTabla> filas;

	public Tabla(Grupo grupo) {
		this.setIdGrupo(grupo.getId());
		this.setNombreGrupo(grupo.getNombre());
		this.filas = new ArrayList<>();
	}
	
	public void addEquipo(FilaTabla equipo) {
		this.filas.add(equipo);
	}
	
	public void ordenar() {
		Collections.sort(filas);
	}
	
	public List<FilaTabla> getFilas() {
		return filas;
	}
	public void setFilas(List<FilaTabla> filas) {
		this.filas = filas;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreTorneo) {
		this.nombreGrupo = nombreTorneo;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	@Override
	public int compareTo(Tabla o) {
		return this.nombreGrupo.compareTo(o.getNombreGrupo());
	}
	
}
