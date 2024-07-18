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
@Table(name = "PROYECTO")
public class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PROYECTO")
	private int idProyecto;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String desc;
	
	@Column(name = "FECHA_INICIO")
	private String fechaini;
	
	@Column(name = "FECHA_FIN")
	private String fechafin;
	
	@Column(name = "PRESUPUESTO")
	private float ppto;
	
	@Column(name = "ESTADO")
	private String estadopro;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
	@JsonIgnore
	private List<Sesion> sesiones;

	public Proyecto() {
		
	}

	public Proyecto(String nombre, String desc, String fechaini, String fechafin, float ppto, String estadopro,
			List<Sesion> sesiones) {
		this.nombre = nombre;
		this.desc = desc;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.ppto = ppto;
		this.estadopro = estadopro;
		this.sesiones = sesiones;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public float getPpto() {
		return ppto;
	}

	public void setPpto(float ppto) {
		this.ppto = ppto;
	}

	public String getEstadopro() {
		return estadopro;
	}

	public void setEstadopro(String estadopro) {
		this.estadopro = estadopro;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

}
