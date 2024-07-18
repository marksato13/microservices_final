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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARTIDO")
public class Partido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PARTIDO")
	private int idPartido;
	
	@Column(name = "HORA")
	private String hora;
	
	@ManyToOne
	@JoinColumn(name = "JORNADA_ID")
	private Jornada jornada;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "partido")
	@JsonIgnore
	private Resultado resultado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
	@JsonIgnore
	private List<Participacion> participaciones;

	public Partido() {
		
	}

	public Partido(String hora, Jornada jornada, Resultado resultado, List<Participacion> participaciones) {
		this.hora = hora;
		this.jornada = jornada;
		this.resultado = resultado;
		this.participaciones = participaciones;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public List<Participacion> getParticipaciones() {
		return participaciones;
	}

	public void setParticipaciones(List<Participacion> participaciones) {
		this.participaciones = participaciones;
	}
	
}
