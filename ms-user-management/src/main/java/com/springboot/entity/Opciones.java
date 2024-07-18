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
@Table(name="OPCIONES")
public class Opciones{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPCIONES")
    private Integer id;
	
	@Column(name = "RUTA_ACCESOS")
	@NotNull @NotBlank    
    private String ruta_accesos;
	
	@Column(name = "NOMBRE")
	@NotNull @NotBlank    
    private String nombre;
	
	@Column(name = "SUBMENU")
	@NotNull @NotBlank    
    private int id_submenu;
	
	@Column(name = "MODULO")
	@NotNull @NotBlank    
    private int modulo;
	
		
//TODO RELACIONES 	
	
	//ROL OPCIONES
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opciones")
	@JsonIgnore
	private Set<Rol_Opciones> rol_opciones;
}
