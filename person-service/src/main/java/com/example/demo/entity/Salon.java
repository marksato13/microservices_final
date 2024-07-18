package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "salon")
	@JsonIgnore
	private List<Alumno> alumnos;
	
	
	public Salon() {
		
	}

	public Salon(String grupo, List<Alumno> alumnos) {
		super();
		this.grupo = grupo;
		this.alumnos = alumnos;
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

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
