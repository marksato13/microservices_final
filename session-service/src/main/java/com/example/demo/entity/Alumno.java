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
@Table(name = "ALUMNO")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO")
	private int idAlumno;
	
	@Column(name = "CODIGO")
	private int codigoalum;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
	@JsonIgnore
	private List<Asistencia> asistencias;
	
	public Alumno() {
		
	}
	
	public Alumno(int codigoalum, List<Asistencia> asistencias) {
		this.codigoalum = codigoalum;
		this.asistencias = asistencias;
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

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
}
