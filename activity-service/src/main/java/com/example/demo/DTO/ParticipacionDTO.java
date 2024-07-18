package com.example.demo.DTO;

public class ParticipacionDTO {
	private String estadolov;
	private int idPartido;
	private int idEquipo;
	
	
	public ParticipacionDTO() {
		
	}

	public ParticipacionDTO(String estadolov, int idPartido, int idEquipo) {
		this.estadolov = estadolov;
		this.idPartido = idPartido;
		this.idEquipo = idEquipo;
	}

	public String getEstadolov() {
		return estadolov;
	}

	public void setEstadolov(String estadolov) {
		this.estadolov = estadolov;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
}
