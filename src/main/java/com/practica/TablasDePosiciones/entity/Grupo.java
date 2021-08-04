package com.practica.TablasDePosiciones.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany
    @JoinTable(
            name = "equipos_grupo",
            joinColumns = {@JoinColumn(name = "grupo_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipo_id")}
    )
	private Set<Equipo> equipos;
		
	public Grupo() {
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

	public Set<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nombre=" + nombre + ", equipos=" + equipos + "]";
	}

}
