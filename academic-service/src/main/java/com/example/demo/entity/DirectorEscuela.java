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
@Table(name = "DIRECTOR_ESC")
public class DirectorEscuela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECTOR_ESC")
	private int idDiresc;
	
	@Column(name = "CODIGO")
	private int codigodir;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "diresc")
	@JsonIgnore
	private Escuela escuela;

	public DirectorEscuela() {
		
	}

	public DirectorEscuela(int codigodir, Escuela escuela) {
		this.codigodir = codigodir;
		this.escuela = escuela;
	}

	public int getIdDiresc() {
		return idDiresc;
	}

	public void setIdDiresc(int idDiresc) {
		this.idDiresc = idDiresc;
	}

	public int getCodigodir() {
		return codigodir;
	}

	public void setCodigodir(int codigodir) {
		this.codigodir = codigodir;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
}
