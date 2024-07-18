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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="ROL")
public class Rol {
	
	@Id
	@Column(name = "ID_ROL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "NOMBRE_ROL")
	@NotNull @NotBlank    
    private String nombre_rol;
	
//TODO RELACIONES 	
	
	//ROL OPCIONES
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	@JsonIgnore
	private Set<Rol_Opciones> rol_opciones;
	
	//USUARIO ROL
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	@JsonIgnore
	private Set<Usuario_Rol> usuario_rol;
	


	
	
}
