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
@Table(name = "CHAMPIONS")
public class Champions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CHAMPIONS")
	private int idChampions;
	
	@Column(name = "NOMBRE")
	private String nombrech;
	
	@Column(name = "FECHA_INICIO")
	private String fechaini;
	
	@Column(name = "FECHA_FIN")
	private String fechafin;
	
	@Column(name = "ENCARGADO")
	private String encargado;
	
	@Column(name = "ESTADO")
	private String estadoch;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "champions")
	@JsonIgnore
	private List<Jornada> jornadas;

	public Champions() {
		
	}

	public Champions(String nombrech, String fechaini, String fechafin, String encargado, String estadoch,
			List<Jornada> jornadas) {
		this.nombrech = nombrech;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.encargado = encargado;
		this.estadoch = estadoch;
		this.jornadas = jornadas;
	}

	public int getIdChampions() {
		return idChampions;
	}

	public void setIdChampions(int idChampions) {
		this.idChampions = idChampions;
	}

	public String getNombrech() {
		return nombrech;
	}

	public void setNombrech(String nombrech) {
		this.nombrech = nombrech;
	}

	public String getFechaini() {
		return fechaini;
	}

	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getEstadoch() {
		return estadoch;
	}

	public void setEstadoch(String estadoch) {
		this.estadoch = estadoch;
	}

	public List<Jornada> getJornadas() {
		return jornadas;
	}

	public void setJornadas(List<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	
}
