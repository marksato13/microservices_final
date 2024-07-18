package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;
	
	public DirectorEscuela() {
		
	}

	public DirectorEscuela(int codigodir, Persona persona) {
		this.codigodir = codigodir;
		this.persona = persona;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
