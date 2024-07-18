package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEMESTRE")
public class Semestre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SEMESTRE")
	private int idSemestre;

	@Column(name = "NOMBRESEM")
	private String nombresem;


	public Semestre() {
		
	}

	public Semestre(String nombresem) {
		this.nombresem = nombresem;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getNombresem() {
		return nombresem;
	}

	public void setNombresem(String nombresem) {
		this.nombresem = nombresem;
	}
}
