package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ASISTENCIA")
public class Asistencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ASISTENCIA")
	private int idAsistencia;
	
	@Column(name = "ESTADO")
	private String estadoasis;
	
	@ManyToOne
	@JoinColumn(name = "SESION_ID")
	private Sesion sesion;
	
	@ManyToOne
	@JoinColumn(name = "ALUMNO_ID")
	private Alumno alumno;

	public Asistencia() {
		
	}

	public Asistencia(String estadoasis, Sesion sesion, Alumno alumno) {
		this.estadoasis = estadoasis;
		this.sesion = sesion;
		this.alumno = alumno;
	}

	public int getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public String isEstadoasis() {
		return estadoasis;
	}

	public void setEstadoasis(String estadoasis) {
		this.estadoasis = estadoasis;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
