package com.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name="ROL_OPCIONES")
public class Rol_Opciones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL_ACCESOS")
    private Integer id;
	
//TODO RELACIONES 	

	// ROL OCIONES 
	@ManyToOne
	@JoinColumn(name="ID_OPCIONES", nullable = false)
	private Opciones opciones;
	
	@ManyToOne
	@JoinColumn(name="ID_ROL", nullable = false)
	private Rol rol;
	
}
