package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private int idPersona;
	
	@Column(name = "NOMBRES")
	private String nombre;
	
	@Column(name = "APELLIDO_PAT")
	private String apepat;
	
	@Column(name = "APELLIDO_MAT")
	private String apemat;
	
	@Column(name = "DNI")
	private int dni;
	
	@Column(name = "TELEFONO")
	private int telf;
	
	@Column(name = "DIRECCION")
	private String direc;
	
	@Column(name = "CORREO_PERS")
	private String correo;
	
	@Column(name = "FECHA_NAC")
	private String fechanac;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	@JsonIgnore
	private DirectorEscuela diresc;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	@JsonIgnore
	private CoordinadorTutoria coordtut;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	@JsonIgnore
	private Alumno alum;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	@JsonIgnore
	private Tutor tutor;
	
	public Persona() {
		
	}

	public Persona(String nombre, String apepat, String apemat, int dni, int telf, String direc, String correo,
			String fechanac, DirectorEscuela diresc, CoordinadorTutoria coordtut, Alumno alum, Tutor tutor) {
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
		this.dni = dni;
		this.telf = telf;
		this.direc = direc;
		this.correo = correo;
		this.fechanac = fechanac;
		this.diresc = diresc;
		this.coordtut = coordtut;
		this.alum = alum;
		this.tutor = tutor;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public DirectorEscuela getDiresc() {
		return diresc;
	}

	public void setDiresc(DirectorEscuela diresc) {
		this.diresc = diresc;
	}

	public CoordinadorTutoria getCoordtut() {
		return coordtut;
	}

	public void setCoordtut(CoordinadorTutoria coordtut) {
		this.coordtut = coordtut;
	}

	public Alumno getAlum() {
		return alum;
	}

	public void setAlum(Alumno alum) {
		this.alum = alum;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}
