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
@Table(name = "LUGAR")
public class Lugar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_LUGAR")
	private int idLugar;
	
	@Column(name = "NOMBRE")
	private String nombrelug;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lugar")
	@JsonIgnore
	private List<Jornada> jornadas ;

	public Lugar() {
		
	}

	public Lugar(String nombrelug, List<Jornada> jornadas) {
		this.nombrelug = nombrelug;
		this.jornadas = jornadas;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombrelug() {
		return nombrelug;
	}

	public void setNombrelug(String nombrelug) {
		this.nombrelug = nombrelug;
	}

	public List<Jornada> getJornadas() {
		return jornadas;
	}

	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	
}
