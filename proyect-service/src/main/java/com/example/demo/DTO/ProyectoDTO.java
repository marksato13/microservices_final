package com.example.demo.DTO;

public class ProyectoDTO {
	
	private String nombre;
	private String descripcion;
	private String fechaini;
	private String fechafin;
	private float ppto;
	private String estadopro;
	
	private int idTipoPro;
	private int idSemestre;
	private int idEscuela;
	
	public ProyectoDTO() {
	}

	public ProyectoDTO(String nombre, String descripcion, String fechaini, String fechafin, float ppto, String estadopro,
			int idTipoPro, int idSemestre, int idEscuela) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.ppto = ppto;
		this.estadopro = estadopro;
		this.idTipoPro = idTipoPro;
		this.idSemestre = idSemestre;
		this.idEscuela = idEscuela;
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

	public void setDgescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getIdTipoPro() {
		return idTipoPro;
	}

	public void setIdTipoPro(int idTipoPro) {
		this.idTipoPro = idTipoPro;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public int getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}

}
