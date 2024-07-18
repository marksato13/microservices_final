package com.example.demo.DTO;

public class SesionDTO {
	private String nombrese;
	private String fecha;
	private String encargado;
	private String urlrec;

	private int idTipoSes;
	private int idLugar;
	private int idProyecto;
	
	public SesionDTO() {
		
	}

	public SesionDTO(String nombrese, String fecha, String encargado, String urlrec, int idTipoSes, int idLugar,
			int idProyecto) {
		this.nombrese = nombrese;
		this.fecha = fecha;
		this.encargado = encargado;
		this.urlrec = urlrec;
		this.idTipoSes = idTipoSes;
		this.idLugar = idLugar;
		this.idProyecto = idProyecto;
	}

	public String getNombrese() {
		return nombrese;
	}

	public void setNombrese(String nombrese) {
		this.nombrese = nombrese;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getUrlrec() {
		return urlrec;
	}

	public void setUrlrec(String urlrec) {
		this.urlrec = urlrec;
	}

	public int getIdTipoSes() {
		return idTipoSes;
	}

	public void setIdTipoSes(int idTipoSes) {
		this.idTipoSes = idTipoSes;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
}
