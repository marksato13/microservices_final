package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LUGAR")
public class Lugar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_LUGAR")
	private int idLugar;
	
	@Column(name = "NOMBRE")
	private String nombrelug;
	

	public Lugar() {
		
	}

	public Lugar(String nombrelug) {
		this.nombrelug = nombrelug;
	}

	public int getIdLugar() {
		return idLugar;
	}

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	public String getNombrelug() {
		return nombrelug;
	}

	public void setNombrelug(String nombrelug) {
		this.nombrelug = nombrelug;
	}
	
}
