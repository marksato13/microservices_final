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
@Table(name = "CICLO")
public class Ciclo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CICLO")
	private int idCiclo;
	
	@Column(name = "CICLO")
	private String ciclo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
	@JsonIgnore
	private List<Salon> salones;

	public Ciclo() {
		
	}

	public Ciclo(String ciclo, List<Salon> salones) {
		this.ciclo = ciclo;
		this.salones = salones;
	}

	public int getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public List<Salon> getSalones() {
		return salones;
	}

	public void setSalones(List<Salon> salones) {
		this.salones = salones;
	}
	
}
