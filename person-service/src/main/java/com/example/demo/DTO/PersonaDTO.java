package com.example.demo.DTO;

public class PersonaDTO {
	private String nombre;
	private String apepat;
	private String apemat;
	private int dni;
	private int telf;
	private String direc;
	private String correo;
	private String fechanac;
	
	public PersonaDTO() {
		
	}
	public PersonaDTO(String nombre, String apepat, String apemat, int dni, int telf, String direc, String correo,
			String fechanac) {
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
		this.dni = dni;
		this.telf = telf;
		this.direc = direc;
		this.correo = correo;
		this.fechanac = fechanac;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public String getApemat() {
		return apemat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelf() {
		return telf;
	}
	public void setTelf(int telf) {
		this.telf = telf;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	
}
