package com.example.demo.DTO;

public class TutorDTO {
	private int codigotut;
	
	private int idEscuela;
	private int idPersona;
	
	public TutorDTO() {
		
	}

	public TutorDTO(int codigotut, int idEscuela, int idPersona) {
		this.codigotut = codigotut;
		this.idEscuela = idEscuela;
		this.idPersona = idPersona;
	}

	public int getCodigotut() {
		return codigotut;
	}

	public void setCodigotut(int codigotut) {
		this.codigotut = codigotut;
	}

	public int getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
