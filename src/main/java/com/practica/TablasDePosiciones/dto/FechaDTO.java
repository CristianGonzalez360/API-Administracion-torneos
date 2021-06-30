package com.practica.TablasDePosiciones.dto;

public class FechaDTO {

	private int id;
	private int numero;
	private int idTorneo;
	
	public FechaDTO(int id, int numero, int idTorneo) {
		this.id = id;
		this.numero = numero;
		this.idTorneo = idTorneo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}	
}
