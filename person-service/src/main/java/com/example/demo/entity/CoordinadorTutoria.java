package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;
	
	public CoordinadorTutoria() {
		
	}

	public CoordinadorTutoria(int codigocoordtut, Persona persona) {
		this.codigocoordtut = codigocoordtut;
		this.persona = persona;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
