package com.practica.TablasDePosiciones.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "torneo")
public class Torneo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  = "id")
	private int id;
	
	@Column(name  = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name = "torneo")
	private Set<Grupo> grupos;
	
	@Column(name = "enCurso")
	private boolean enCurso;
	
	@Column(name = "fechaInicio")
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaInicio;
	
	@Column(name = "fechaFin")
	private Date fechaFin;
	
	public Torneo() {
		this.enCurso = true;
		this.grupos = new HashSet<>();
		this.fechaInicio = new Date();
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
		
	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
		if(!enCurso) {
			this.fechaFin = new Date();
		}
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

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", grupos=" + grupos
				+ ", enCurso=" + enCurso + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
}
