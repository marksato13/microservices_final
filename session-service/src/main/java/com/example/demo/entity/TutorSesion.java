package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TUTOR_SESION")
public class TutorSesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUTOR_SES")
	private int idTutorses;
	
	@ManyToOne
	@JoinColumn(name = "TUTOR_ID")
	private Tutor tutor;
	
	@ManyToOne
	@JoinColumn(name = "Sesion_ID")
	private Sesion sesion;
}
