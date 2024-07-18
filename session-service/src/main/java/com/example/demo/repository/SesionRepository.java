package com.example.demo.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion,Integer> {

	@Query(value = "SELECT * FROM SESION S WHERE S.PROYECTO_ID = ?1",nativeQuery = true)
	List<Sesion> findSesionbyProQueryNative(int idProyecto);
	
	@Query(value = "SELECT " +
            "S.ID_SESION AS 'idSesion', " +
            "S.NOMBRE AS 'nombreSesion', " +
            "S.FECHA AS 'fecha', " +
            "P.ID_PROYECTO AS 'idProyecto', " +
            "P.NOMBRE AS 'nombreProyecto', " +
            "P.DESCRIPCION AS 'descripcion' " +
            "FROM PROYECTO P " +
            "JOIN SESION S ON S.PROYECTO_ID = P.ID_PROYECTO " +
            "WHERE P.ID_PROYECTO = ?1", nativeQuery = true)
List<Map<String, Object>> findSesionByProyecto(int idProyecto);
}