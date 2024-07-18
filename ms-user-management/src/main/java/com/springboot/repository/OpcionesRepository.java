package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Opciones;

@Repository
public interface OpcionesRepository extends JpaRepository<Opciones, Integer>{

}