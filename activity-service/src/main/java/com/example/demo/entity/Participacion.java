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
@Table(name = "PARTICIPACION")
public class Participacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PARTICIPACION")
	private int idPartc;
	
	@Column(name = "ESTADO")
	private String estadolov;
	
	@ManyToOne
	@JoinColumn(name = "PARTIDO_ID")
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name = "EQUIPO_ID")
	private Equipo equipo;

	public Participacion() {
		
	}

	public Participacion(String estadolov, Partido partido, Equipo equipo) {
		this.estadolov = estadolov;
		this.partido = partido;
		this.equipo = equipo;
	}

	public int getIdPartc() {
		return idPartc;
	}

	public void setIdPartc(int idPartc) {
		this.idPartc = idPartc;
	}

	public String getEstadolov() {
		return estadolov;
	}

	public void setEstadolov(String estadolov) {
		this.estadolov = estadolov;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
}
