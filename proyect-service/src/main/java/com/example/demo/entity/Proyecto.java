package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	private String fechaini;
	
	@Column(name = "FECHA_FIN")
	private String fechafin;
	
	@Column(name = "PRESUPUESTO")
	private float ppto;
	
	@Column(name = "ESTADO")
	private String estadopro;
	
	@ManyToOne
	@JoinColumn(name = "TIPOPRO_ID")
	private TipoPro tipopro;
	
	@ManyToOne
	@JoinColumn(name = "SEMESTRE_ID")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name = "ESCUELA_ID")
	private Escuela escuela;
	

	public Proyecto() {
		
	}
	
	public Proyecto(String nombre, String descripcion, String fechaini, String fechafin, float ppto, String estadopro,
			TipoPro tipopro, Semestre semestre, Escuela escuela) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.ppto = ppto;
		this.estadopro = estadopro;
		this.tipopro = tipopro;
		this.semestre = semestre;
		this.escuela = escuela;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
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


	public TipoPro getTipopro() {
		return tipopro;
	}

	public void setTipopro(TipoPro tipopro) {
		this.tipopro = tipopro;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
}
