package com.practica.TablasDePosiciones.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EstadoPartidoConverter implements AttributeConverter<EstadoPartido, String> {

	@Override
	public String convertToDatabaseColumn(EstadoPartido attribute) {
		return attribute.name();
	}

	@Override
	public EstadoPartido convertToEntityAttribute(String dbData) {
		return EstadoPartido.create(dbData);
	}

}
