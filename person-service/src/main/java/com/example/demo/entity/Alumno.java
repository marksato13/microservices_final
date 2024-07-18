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
@Table(name = "ALUMNO")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO")
	private int idAlumno;
	
	@Column(name = "CODIGO")
	private int codigoalum;
	
	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "SALON_ID")
	private Salon salon;
	
	public Alumno() {
		
	}

	public Alumno(int codigoalum, Persona persona, Salon salon) {
		this.codigoalum = codigoalum;
		this.persona = persona;
		this.salon = salon;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getCodigoalum() {
		return codigoalum;
	}

	public void setCodigoalum(int codigoalum) {
		this.codigoalum = codigoalum;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
}
