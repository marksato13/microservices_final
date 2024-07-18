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
@Table(name = "SALON")
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALON")
	private int idSalon;
	
	@Column(name = "GRUPO")
	private String grupo;
	
	@ManyToOne
	@JoinColumn(name = "CICLO_ID")
	private Ciclo ciclo;
	
	@OneToOne
	@JoinColumn(name = "TUTOR_ID")
	private Tutor tutor;

	public Salon() {
		
	}

	public Salon(String grupo, Ciclo ciclo, Tutor tutor) {
		this.grupo = grupo;
		this.ciclo = ciclo;
		this.tutor = tutor;
	}

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
}
