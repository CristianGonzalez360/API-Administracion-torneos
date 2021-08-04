package com.practica.TablasDePosiciones.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import com.practica.TablasDePosiciones.entity.Categoria;
import com.practica.TablasDePosiciones.entity.Grupo;
import com.practica.TablasDePosiciones.entity.Torneo;

public class TorneoDTO {

	private int id;
	private String nombre;
	private Categoria categoria;
	private ArrayList<GrupoDTO> grupos;
	private boolean enCurso;
	private Date fechaInicio;
	private Date fechaFin;
	
	public TorneoDTO(Torneo torneo) {
		this.categoria = torneo.getCategoria();
		this.id = torneo.getId();
		this.nombre = torneo.getNombre();
		this.enCurso = torneo.isEnCurso();
		this.fechaInicio = torneo.getFechaInicio();
		this.fechaFin = torneo.getFechaFin();
		this.grupos = new ArrayList<>();
		for(Grupo g : torneo.getGrupos()) {
			this.grupos.add(new GrupoDTO(g));
		}
		Collections.sort(this.grupos);
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ArrayList<GrupoDTO> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<GrupoDTO> grupos) {
		this.grupos = grupos;
	}

	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
