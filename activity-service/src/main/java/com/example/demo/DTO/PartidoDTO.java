package com.example.demo.DTO;

public class PartidoDTO {
	private String hora;
	private int idJornada;
	private int idEquipo;
	
	public PartidoDTO() {
		
	}
	
	public PartidoDTO(String hora, int idJornada, int idEquipo) {
		this.hora = hora;
		this.idJornada = idJornada;
		this.idEquipo = idEquipo;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getIdJornada() {
		return idJornada;
	}
	public void setIdJornada(int idJornada) {
		this.idJornada = idJornada;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	
}
