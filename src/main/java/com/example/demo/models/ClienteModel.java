package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private int cedula;
    private String telefono;

    public ClienteModel() {
    }

    public ClienteModel(String nombre, String email, int cedula, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public int getCedula() {return cedula; }
    public void setCedula(int cedula) {this.cedula = cedula; }

    public String getTelefono() {return telefono;  }
    public void setTelefono(String telefono) {this.telefono = telefono; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

