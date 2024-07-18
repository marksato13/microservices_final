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
@Table(name = "TIPO_PROYECTO")
public class TipoPro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPOPRO")
	private int idTipoPro;
	
	@Column(name = "TIPO")
	private String tipo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipopro")
	@JsonIgnore
	private List<Proyecto> proyectos;
	
	public TipoPro() {
		
	}

	public TipoPro(String tipo, List<Proyecto> proyectos) {
		this.tipo = tipo;
		this.proyectos = proyectos;
	}

	public int getIdTipoPro() {
		return idTipoPro;
	}

	public void setIdTipoPro(int idTipoPro) {
		this.idTipoPro = idTipoPro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
