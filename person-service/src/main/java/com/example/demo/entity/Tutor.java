package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TUTOR")
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUTOR")
	private  int idTutor;
	
	@Column(name = "CODIGO")
	private int codigotut;
	
	@ManyToOne
	@JoinColumn(name = "ESCUELA_ID")
	private Escuela escuela;
	
	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;

	public Tutor() {
		
	}

	public Tutor(int codigotut, Escuela escuela, Persona persona) {
		this.codigotut = codigotut;
		this.escuela = escuela;
		this.persona = persona;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getCodigotut() {
		return codigotut;
	}

	public void setCodigotut(int codigotut) {
		this.codigotut = codigotut;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
