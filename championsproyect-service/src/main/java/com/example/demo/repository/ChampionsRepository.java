package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Champions;

@Repository
public interface ChampionsRepository extends JpaRepository<Champions,Integer> {

}
