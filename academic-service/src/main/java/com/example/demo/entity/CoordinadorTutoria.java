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
@Table(name = "COORDINADOR_TUT")
public class CoordinadorTutoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COORDINADOR_TUT")
	private int idCoordtut;
	
	@Column(name = "CODIGO")
	private int codigocoordtut;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "coordtut")
	@JsonIgnore
	private Escuela escuela;

	public CoordinadorTutoria() {
		
	}

	public CoordinadorTutoria(int codigocoordtut, Escuela escuela) {
		this.codigocoordtut = codigocoordtut;
		this.escuela = escuela;
	}

	public int getIdCoordtut() {
		return idCoordtut;
	}

	public void setIdCoordtut(int idCoordtut) {
		this.idCoordtut = idCoordtut;
	}

	public int getCodigocoordtut() {
		return codigocoordtut;
	}

	public void setCodigocoordtut(int codigocoordtut) {
		this.codigocoordtut = codigocoordtut;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
}
