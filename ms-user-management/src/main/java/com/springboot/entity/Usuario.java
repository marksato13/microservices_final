package com.springboot.entity;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer id;

	@Column(name = "NOMBRE_USER")
	@NotNull
	@NotBlank
	private String nombre_user;

	@Column(name = "CONTRASEÑA")
	@NotNull
	@NotBlank
	private String contraseña;

	@Column(name = "IMG_PERFIL")
	@NotNull
	@NotBlank
	private String img_perfil;

//TODO RELACIONES 	

	// USUARIO OPCIONES
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
//	@JsonIgnore
//	private Set<Usuario_Opciones> usuario_opciones;

	// USUARIO ROL
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuarios")
	@JsonIgnore
	private Set<Usuario_Rol> usuario_rol;

	// Relación uno a uno con Persona
	@OneToOne
	@JoinColumn(name = "PERSONA_ID", referencedColumnName = "ID_PERSONA")
	private Persona persona;
}
