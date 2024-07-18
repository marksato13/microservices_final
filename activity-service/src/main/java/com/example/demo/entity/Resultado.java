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
@Table(name = "RESULTADO")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESULTADO")
	private int idResultado;
	
	@Column(name = "PUNTOS_LOCAL")
	private String ptsl;
	
	@Column(name = "PUNTOS_VISITA")
	private String ptsv;
	
	@OneToOne
	@JoinColumn(name = "PARTIDO_ID")
	private Partido partido;

	public Resultado() {
		
	}

	public Resultado(String ptsl, String ptsv, Partido partido) {
		this.ptsl = ptsl;
		this.ptsv = ptsv;
		this.partido = partido;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public String getPtsl() {
		return ptsl;
	}

	public void setPtsl(String ptsl) {
		this.ptsl = ptsl;
	}

	public String getPtsv() {
		return ptsv;
	}

	public void setPtsv(String ptsv) {
		this.ptsv = ptsv;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
}
