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
@Table(name = "FACULTAD")
public class Facultad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FACULTAD")
	private int idFacultad;
	
	@Column(name = "NOMBRE")
	private String nombrefac;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad")
	@JsonIgnore
	private List<Escuela> escuelas;
	
	public Facultad() {
		
	}

	public Facultad(String nombrefac, List<Escuela> escuelas) {
		this.nombrefac = nombrefac;
		this.escuelas = escuelas;
	}

	public int getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(int idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombrefac() {
		return nombrefac;
	}

	public void setNombrefac(String nombrefac) {
		this.nombrefac = nombrefac;
	}

	public List<Escuela> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
	}
	
}
