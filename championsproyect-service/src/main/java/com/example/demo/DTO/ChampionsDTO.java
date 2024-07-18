package com.example.demo.DTO;

public class ChampionsDTO {
	
	private String nombrech;
	private String fechaini;
	private String fechafin;
	private String encargado;
	private String estadoch;
	
	private int idSemestre;

	public ChampionsDTO() {
		
	}

	public ChampionsDTO(String nombrech, String fechaini, String fechafin, String encargado, String estadoch,
			int idSemestre) {
		this.nombrech = nombrech;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.encargado = encargado;
		this.estadoch = estadoch;
		this.idSemestre = idSemestre;
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

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

}
