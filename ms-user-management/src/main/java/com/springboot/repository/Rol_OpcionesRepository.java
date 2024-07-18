package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Rol_Opciones;
@Repository
public interface Rol_OpcionesRepository extends JpaRepository<Rol_Opciones, Integer>{

}