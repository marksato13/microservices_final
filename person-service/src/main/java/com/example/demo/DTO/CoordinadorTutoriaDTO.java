package com.example.demo.DTO;

public class CoordinadorTutoriaDTO {
	private int codigocoordtut;
	
	private int idPersona;

	public CoordinadorTutoriaDTO() {
		
	}

	public CoordinadorTutoriaDTO(int codigocoordtut, int idPersona) {
		this.codigocoordtut = codigocoordtut;
		this.idPersona = idPersona;
	}

	public int getCodigocoordtut() {
		return codigocoordtut;
	}

	public void setCodigocoordtut(int codigocoordtut) {
		this.codigocoordtut = codigocoordtut;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	
}
