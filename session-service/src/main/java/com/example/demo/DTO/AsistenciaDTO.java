package com.example.demo.DTO;

public class AsistenciaDTO {
	private String estadoasis;
	
	private int idSesion;
	private int idAlumno;

	public AsistenciaDTO() {
		
	}

	public AsistenciaDTO(String estadoasis, int idSesion, int idAlumno) {
		this.estadoasis = estadoasis;
		this.idSesion = idSesion;
		this.idAlumno = idAlumno;
	}


	public String getEstadoasis() {
		return estadoasis;
	}


	public void setEstadoasis(String estadoasis) {
		this.estadoasis = estadoasis;
	}


	public int getIdSesion() {
		return idSesion;
	}


	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}


	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

}
