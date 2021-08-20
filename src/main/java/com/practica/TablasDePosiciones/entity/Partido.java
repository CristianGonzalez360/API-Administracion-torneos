package com.practica.TablasDePosiciones.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partido")
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "local")
	private Equipo local;
	
	@ManyToOne
	@JoinColumn(name = "visitante")
	private Equipo visitante;
	
	@Column(name = "golesLocal")
	private int golesLocal;
	
	@Column(name = "golesVisitante")
	private int golesVisitante;

	@Column(name = "fechaJugado")
	private Date fechaJugado;
	
	@ManyToOne
	@JoinColumn(name = "fecha")
	private Fecha fecha;
	
	@Column(name = "estado", length = 15)
	private EstadoPartido estado;

	public Partido() {

 	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getLocal() {
		return local;
	}

	public void setLocal(Equipo local) {
		this.local = local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	
	public Date getFechaJugado() {
		return fechaJugado;
	}

	public void setFechaJugado(Date fechaJugado) {
		this.fechaJugado = fechaJugado;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public EstadoPartido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPartido estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", local=" + local + ", visitante=" + visitante + ", golesLocal=" + golesLocal
				+ ", golesVisitante=" + golesVisitante + ", fechaJugado=" + fechaJugado + ", fecha=" + fecha + "]";
	}

	public boolean gano(Equipo equipo) {
		boolean ret = false;
		if((this.local.getId()==equipo.getId() && this.golesLocal>this.golesVisitante)
				||(this.visitante.getId()==equipo.getId() && this.golesVisitante>this.golesLocal)) {
			ret = true;
		}
		return ret;
	}

	public boolean perdio(Equipo equipo) {
		boolean ret = false;
		if((this.local.getId()==equipo.getId() && this.golesLocal<this.golesVisitante)
				||(this.visitante.getId()==equipo.getId() && this.golesVisitante<this.golesLocal)) {
			ret = true;
		}
		return ret;
	}

	public boolean empato(Equipo equipo) {
		boolean ret = false;
		if((this.local.getId()==equipo.getId() && this.golesLocal==this.golesVisitante)
				||(this.visitante.getId()==equipo.getId() && this.golesVisitante==this.golesLocal)) {
			ret = true;
		}
		return ret;
	}

	public int getGolesAFavor(Equipo equipo) {
		int ret = 0;
		if(this.local.getId()==equipo.getId()) {
			ret = this.golesLocal;
		}else if(this.visitante.getId()==equipo.getId()) {
			ret = this.golesVisitante;
		}
		return ret;
	}

	public int getGolesEnContra(Equipo equipo) {
		int ret = 0;
		if(this.local.getId()==equipo.getId()) {
			ret = this.golesVisitante;
		}else if(this.visitante.getId()==equipo.getId()) {
			ret = this.golesLocal;
		}
		return ret;
	}		
}
