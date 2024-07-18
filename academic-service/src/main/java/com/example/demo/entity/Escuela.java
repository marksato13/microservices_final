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
@Table(name = "ESCUELA")
public class Escuela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESCUELA")
	private int idEscuela;
	
	@Column(name = "NOMBRE")
	private String nombresc;
	
	@OneToOne
	@JoinColumn(name = "DIRECTOR_ESC_ID")
	private DirectorEscuela diresc;
	
	@OneToOne
	@JoinColumn(name = "COORDINADOR_TUT_ID")
	private CoordinadorTutoria coordtut;
	
	@ManyToOne
	@JoinColumn(name = "FACULTAD_ID")
	private Facultad facultad;

	public Escuela() {
		
	}

	public Escuela(String nombresc, DirectorEscuela diresc, CoordinadorTutoria coordtut, Facultad facultad) {
		this.nombresc = nombresc;
		this.diresc = diresc;
		this.coordtut = coordtut;
		this.facultad = facultad;
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

	public DirectorEscuela getDiresc() {
		return diresc;
	}

	public void setDiresc(DirectorEscuela diresc) {
		this.diresc = diresc;
	}

	public CoordinadorTutoria getCoordtut() {
		return coordtut;
	}

	public void setCoordtut(CoordinadorTutoria coordtut) {
		this.coordtut = coordtut;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

}
