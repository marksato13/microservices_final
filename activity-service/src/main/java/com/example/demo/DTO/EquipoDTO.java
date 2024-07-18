package com.example.demo.DTO;

public class EquipoDTO {
	private String nombrequi;
	
	private int idSalon;

	public EquipoDTO() {
		
	}

	public EquipoDTO(String nombrequi, int idSalon) {
		this.nombrequi = nombrequi;
		this.idSalon = idSalon;
	}

	public String getNombrequi() {
		return nombrequi;
	}

	public void setNombrequi(String nombrequi) {
		this.nombrequi = nombrequi;
	}

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}
	
}
