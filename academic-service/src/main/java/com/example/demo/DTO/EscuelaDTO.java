package com.example.demo.DTO;

public class EscuelaDTO {
	private String nombresc;
	private int idDiresc;
	private int idCoordtut;
	private int idFacultad;
	
	public EscuelaDTO() {
		
	}

	public EscuelaDTO(String nombresc, int idDiresc, int idCoordtut, int idFacultad) {
		this.nombresc = nombresc;
		this.idDiresc = idDiresc;
		this.idCoordtut = idCoordtut;
		this.idFacultad = idFacultad;
	}

	public String getNombresc() {
		return nombresc;
	}

	public void setNombresc(String nombresc) {
		this.nombresc = nombresc;
	}

	public int getIdDiresc() {
		return idDiresc;
	}

	public void setIdDiresc(int idDiresc) {
		this.idDiresc = idDiresc;
	}

	public int getIdCoordtut() {
		return idCoordtut;
	}

	public void setIdCoordtut(int idCoordtut) {
		this.idCoordtut = idCoordtut;
	}

	public int getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(int idFacultad) {
		this.idFacultad = idFacultad;
	}
	
}
