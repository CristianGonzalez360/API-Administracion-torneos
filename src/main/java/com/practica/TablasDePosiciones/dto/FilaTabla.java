package com.practica.TablasDePosiciones.dto;

import com.practica.TablasDePosiciones.entity.Equipo;

public class FilaTabla implements Comparable<FilaTabla> {

	private String nombre;
	private int puntos;
	private int jugados;
	private int ganados;
	private int empatados;
	private int perdidos;
	private int golesAFavor;
	private int golesEnContra;
	private int diferenciaGol;

	public FilaTabla(Equipo equipo) {
		this.nombre = equipo.getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getEmpatados() {
		return empatados;
	}

	public void setEmpatados(int empatados) {
		this.empatados = empatados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public int getGolesAFavor() {
		return golesAFavor;
	}

	public void setGolesAFavor(int golesAFavor) {
		this.golesAFavor = golesAFavor;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	public int getDiferenciaGol() {
		return diferenciaGol;
	}

	public void setDiferenciaGol(int diferenciaGol) {
		this.diferenciaGol = diferenciaGol;
	}

	public int getJugados() {
		return jugados;
	}

	public void setJugados(int jugados) {
		this.jugados = jugados;
	}

	@Override
	public int compareTo(FilaTabla o) {
		int ret = 0;
		if (this.puntos > o.puntos) {
			ret = -1;
		} else if (this.puntos < o.puntos) {
			ret = 1;
		} else if (this.diferenciaGol > o.diferenciaGol) {
			ret = -1;
		} else if (this.diferenciaGol < o.diferenciaGol) {
			ret = 1;
		} else if (this.golesAFavor > o.golesAFavor) {
			ret = -1;
		} else if (this.golesAFavor < o.golesAFavor) {
			ret = 1;
		}
		return ret;
	}

	public void ganado() {
		this.ganados += 1;
		this.jugados += 1;
		this.puntos += 3;
	}

	public void perdido() {
		this.perdidos += 1;
		this.jugados += 1;
	}

	public void empate() {
		this.empatados += 1;
		this.jugados += 1;
		this.puntos += 1;
	}
	
	public void goles(int golesAFavor, int golesEnContra) {
		this.golesAFavor += golesAFavor;
		this.golesEnContra += golesEnContra;
		this.diferenciaGol = this.golesAFavor-this.golesEnContra;
	}

}
