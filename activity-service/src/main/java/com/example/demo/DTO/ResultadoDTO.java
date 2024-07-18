package com.example.demo.DTO;

public class ResultadoDTO {
	private String ptsl;
	private String ptsv;
	
	private int idPartido;

	public ResultadoDTO() {
		
	}

	public ResultadoDTO(String ptsl, String ptsv, int idPartido) {
		this.ptsl = ptsl;
		this.ptsv = ptsv;
		this.idPartido = idPartido;
	}

	public String getPtsl() {
		return ptsl;
	}

	public void setPtsl(String ptsl) {
		this.ptsl = ptsl;
	}

	public String getPtsv() {
		return ptsv;
	}

	public void setPtsv(String ptsv) {
		this.ptsv = ptsv;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

}
