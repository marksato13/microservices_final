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
@Table(name = "ESCUELA")
public class Escuela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESCUELA")
	private int idEscuela;
	
	@Column(name = "NOMBRE")
	private String nombresc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "escuela")
	@JsonIgnore
	private List<Proyecto> proyectos;

	public Escuela() {
		
	}

	public Escuela(String nombresc, List<Proyecto> proyectos) {
		this.nombresc = nombresc;
		this.proyectos = proyectos;
	}

	public int getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}

	public String getNombresc() {
		return nombresc;
	}

	public void setNombresc(String nombresc) {
		this.nombresc = nombresc;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
