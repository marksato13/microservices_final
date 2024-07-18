package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Usuario_Rol;
@Repository
public interface Usuario_RolRepository extends JpaRepository<Usuario_Rol, Integer>{

}