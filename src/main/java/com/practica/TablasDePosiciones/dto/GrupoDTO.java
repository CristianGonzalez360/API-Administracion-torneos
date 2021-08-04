package com.practica.TablasDePosiciones.dto;

import java.util.ArrayList;
import java.util.Collections;

import com.practica.TablasDePosiciones.entity.Equipo;
import com.practica.TablasDePosiciones.entity.Grupo;

public class GrupoDTO implements Comparable<GrupoDTO> {
	
	private int id;
	private String nombre;
	private ArrayList<Equipo> equipos;
	
	public GrupoDTO(Grupo grupo) {
		this.id = grupo.getId();
		this.nombre = grupo.getNombre();
		this.equipos = new ArrayList<>();
		for(Equipo e: grupo.getEquipos()) {
			this.equipos.add(e);
		}
		
		Collections.sort(this.equipos);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public int compareTo(GrupoDTO o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	
}
