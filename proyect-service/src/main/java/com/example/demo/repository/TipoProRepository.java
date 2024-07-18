package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.TipoPro;

@Repository
public interface TipoProRepository extends JpaRepository<TipoPro,Integer> {

}
