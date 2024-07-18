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

@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "USUARIO_ROL")
public class Usuario_Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO_ROL")
	private Integer id;

//TODO RELACIONES 	

	// USUARIO ROL
	@ManyToOne
	@JoinColumn(name = "ID_ROL", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", nullable = false)
	private Usuario usuarios;

}
