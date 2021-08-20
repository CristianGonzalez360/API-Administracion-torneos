package com.practica.TablasDePosiciones.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoPartido {
	PENDIENTE, 
	JUGADO,
	SUSPENDIDO;
	
	@JsonValue
	public String value(){
		return this.name();
	}
	
	@JsonCreator
	public static EstadoPartido create(String name) {
		EstadoPartido ret = EstadoPartido.PENDIENTE;
		if(name != null)
			ret = EstadoPartido.valueOf(name);
		return ret;
	}
}
