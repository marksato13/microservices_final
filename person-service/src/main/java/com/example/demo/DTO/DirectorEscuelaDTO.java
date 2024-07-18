package com.example.demo.DTO;

public class DirectorEscuelaDTO {
	private int codigodir;
	
	private int idPersona;
	
	public DirectorEscuelaDTO() {
		
	}
	
	public DirectorEscuelaDTO(int codigodir, int idPersona) {
		this.codigodir = codigodir;
		this.idPersona = idPersona;
	}
	public int getCodigodir() {
		return codigodir;
	}
	public void setCodigodir(int codigodir) {
		this.codigodir = codigodir;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
