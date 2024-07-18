package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALON")
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALON")
	private int idSalon;
	
	@Column(name = "GRUPO")
	private String grupo;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "salon")
	@JsonIgnore
	private Equipo equipo;
	
	public Salon() {
		
	}

	public Salon(String grupo, Equipo equipo) {
		this.grupo = grupo;
		this.equipo = equipo;
	}

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
