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
@Table(name = "TIPO_SESION")
public class TipoSes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPOSES")
	private int idTipoSes;
	
	@Column(name = "TIPO")
	private String tipo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposes")
	@JsonIgnore
	private List<Sesion> sesiones;

	public TipoSes() {
		
	}

	public TipoSes(String tipo, List<Sesion> sesiones) {
		this.tipo = tipo;
		this.sesiones = sesiones;
	}

	public int getIdTipoSes() {
		return idTipoSes;
	}

	public void setIdTipoSes(int idTipoSes) {
		this.idTipoSes = idTipoSes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
		
}
