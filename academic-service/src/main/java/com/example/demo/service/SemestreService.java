// SemestreService.java
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Semestre;
import com.example.demo.repository.SemestreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SemestreService {
    @Autowired
    SemestreRepository semestreRepository;
    
    public List<Semestre> listar(){
        return semestreRepository.findAll();
    }
    
    public Optional<Semestre> findById(int id){
        return semestreRepository.findById(id);
    }
    
    public void delete(int id) {
        semestreRepository.deleteById(id);
    }
    
    public boolean existById(int id) {
        return semestreRepository.existsById(id);
    }
    
    public void save(Semestre semestre) {
        semestreRepository.save(semestre);
    }
}
