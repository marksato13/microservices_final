package com.example.demo.DTO;

public class JornadaDTO {
	private String fecha;
	private int idDisciplina;
	private int idLugar;
	private int idChampions;
	
	public JornadaDTO() {
		
	}
	
	public JornadaDTO(String fecha, int idDisciplina, int idLugar, int idChampions) {
		this.fecha = fecha;
		this.idDisciplina = idDisciplina;
		this.idLugar = idLugar;
		this.idChampions = idChampions;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public int getIdChampions() {
		return idChampions;
	}

	public void setIdChampions(int idChampions) {
		this.idChampions = idChampions;
	}
	
}
