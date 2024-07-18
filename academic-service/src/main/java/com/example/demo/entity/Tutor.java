package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TUTOR")
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUTOR")
	private  int idTutor;
	
	@Column(name = "CODIGO")
	private int codigotut;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "tutor")
	@JsonIgnore
	private Salon salon;

	public Tutor() {
		
	}

	public Tutor(int codigotut, Salon salon) {
		this.codigotut = codigotut;
		this.salon = salon;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getCodigotut() {
		return codigotut;
	}

	public void setCodigotut(int codigotut) {
		this.codigotut = codigotut;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
}
