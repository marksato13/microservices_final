package com.example.demo.DTO;

public class SalonDTO {
	private String grupo;
	private int idCiclo;
	private int idTutor;
	
	public SalonDTO() {
		
	}

	public SalonDTO(String grupo, int idCiclo, int idTutor) {
		this.grupo = grupo;
		this.idCiclo = idCiclo;
		this.idTutor = idTutor;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

}
