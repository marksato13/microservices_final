package com.example.demo.DTO;

public class AlumnoDTO {
	private int codigoalum;
	
	private int idSalon;
	private int idPersona;
	
	public AlumnoDTO() {
		
	}
	
	public AlumnoDTO(int codigoalum, int idSalon, int idPersona) {
		this.codigoalum = codigoalum;
		this.idSalon = idSalon;
		this.idPersona = idPersona;
	}

	public int getCodigoalum() {
		return codigoalum;
	}


	public void setCodigoalum(int codigoalum) {
		this.codigoalum = codigoalum;
	}


	public int getIdSalon() {
		return idSalon;
	}


	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}


	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
