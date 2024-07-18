package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Rol;
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}