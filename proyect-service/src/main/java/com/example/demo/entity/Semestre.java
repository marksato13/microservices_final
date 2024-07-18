package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEMESTRE")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEMESTRE")
    private int idSemestre;

    @Column(name = "NOMBRESEM")
    private String nombresem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestre")
    @JsonIgnore
    private List<Proyecto> proyectos;

    public Semestre() {
    }

    public Semestre(String nombresem, List<Proyecto> proyectos) {
        this.nombresem = nombresem;
        this.proyectos = proyectos;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNombresem() {
        return nombresem;
    }

    public void setNombresem(String nombresem) {
        this.nombresem = nombresem;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
