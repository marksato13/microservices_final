package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SESION")
public class Sesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SESION")
	private int idSesion;
	
	@Column(name = "NOMBRE")
	private String nombrese;
	
	@Column(name = "FECHA")
	private String fecha;
	
	@Column(name = "ENCARGADO")
	private String encargado;
	
	@Column(name = "URL_RECURSO")
	private String urlrec;
	
	@ManyToOne
	@JoinColumn(name = "TIPOSES_ID")
	private TipoSes tiposes;
	
	@ManyToOne
	@JoinColumn(name = "LUGAR_ID")
	private Lugar lugar;
	
	@ManyToOne
	@JoinColumn(name = "PROYECTO_ID")
	private Proyecto proyecto;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sesion")
	@JsonIgnore
	private List<Asistencia> asistencias;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sesion")
	@JsonIgnore
	private List<TutorSesion> tutorsesiones;
	
	public Sesion() {
		
	}

	public Sesion(String nombrese, String fecha, String encargado, String urlrec, TipoSes tiposes, Lugar lugar,
			Proyecto proyecto, List<Asistencia> asistencias, List<TutorSesion> tutorsesiones) {
		this.nombrese = nombrese;
		this.fecha = fecha;
		this.encargado = encargado;
		this.urlrec = urlrec;
		this.tiposes = tiposes;
		this.lugar = lugar;
		this.proyecto = proyecto;
		this.asistencias = asistencias;
		this.tutorsesiones = tutorsesiones;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public String getNombrese() {
		return nombrese;
	}

	public void setNombrese(String nombrese) {
		this.nombrese = nombrese;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getUrlrec() {
		return urlrec;
	}

	public void setUrlrec(String urlrec) {
		this.urlrec = urlrec;
	}

	public TipoSes getTiposes() {
		return tiposes;
	}

	public void setTiposes(TipoSes tiposes) {
		this.tiposes = tiposes;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public List<TutorSesion> getTutorsesiones() {
		return tutorsesiones;
	}

	public void setTutorsesiones(List<TutorSesion> tutorsesiones) {
		this.tutorsesiones = tutorsesiones;
	}
	
}
