	package com.example.demo.repository;
	

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

	import com.example.demo.entity.Proyecto;

	
	@Repository
	public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
		
	    List<Proyecto> findBySemestreIdSemestre(int idSemestre);
	    
	    List<Proyecto> findByTipoproIdTipoPro(int idTipoPro);
	    
	    List<Proyecto> findBySemestreIdSemestreAndTipoproIdTipoPro(int idSemestre, int idTipoPro);
	}