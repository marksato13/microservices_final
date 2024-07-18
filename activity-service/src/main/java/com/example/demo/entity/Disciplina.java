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
@Table(name = "DISCIPLINA")
public class Disciplina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_DISCIPLINA")
	private int idDisciplina;
	
	@Column(name = "NOMBRE")
	private String nombredis;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
	@JsonIgnore
	private List<Jornada> jornadas;

	public Disciplina() {
		
	}

	public Disciplina(String nombredis, List<Jornada> jornadas) {
		this.nombredis = nombredis;
		this.jornadas = jornadas;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNombredis() {
		return nombredis;
	}

	public void setNombredis(String nombredis) {
		this.nombredis = nombredis;
	}

	public List<Jornada> getJornadas() {
		return jornadas;
	}

	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	
}
