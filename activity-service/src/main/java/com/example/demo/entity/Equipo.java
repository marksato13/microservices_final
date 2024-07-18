package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EQUIPO")
public class Equipo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_EQUIPO")
	private int idEquipo;
	
	@Column(name = "NOMBRE")
	private String nombrequi;
	
	@OneToOne
	@JoinColumn(name = "SALON_ID")
	private Salon salon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
	@JsonIgnore
	private List<Participacion> participaciones;


	public Equipo() {
		
	}

	public Equipo(String nombrequi, Salon salon, List<Participacion> participaciones) {
		super();
		this.nombrequi = nombrequi;
		this.salon = salon;
		this.participaciones = participaciones;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombrequi() {
		return nombrequi;
	}

	public void setNombrequi(String nombrequi) {
		this.nombrequi = nombrequi;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public List<Participacion> getParticipaciones() {
		return participaciones;
	}

	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}
	
}
