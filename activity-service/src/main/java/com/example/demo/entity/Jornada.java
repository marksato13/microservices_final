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
import jakarta.persistence.Table;

@Entity
@Table(name = "JORNADA")
public class Jornada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_JORNADA")
	private int idJornada;
	
	@Column(name = "FECHA")
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name = "DISCIPLINA_ID")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name = "LUGAR_ID")
	private Lugar lugar;
	
	@ManyToOne
	@JoinColumn(name = "CHAMPIONS_ID")
	private Champions champions;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jornada")
	@JsonIgnore
	private List<Partido> partidos;

	public Jornada() {
		
	}

	public Jornada(String fecha, Disciplina disciplina, Lugar lugar, Champions champions, List<Partido> partidos) {
		this.fecha = fecha;
		this.disciplina = disciplina;
		this.lugar = lugar;
		this.champions = champions;
		this.partidos = partidos;
	}

	public int getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(int idJornada) {
		this.idJornada = idJornada;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Champions getChampions() {
		return champions;
	}

	public void setChampions(Champions champions) {
		this.champions = champions;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
