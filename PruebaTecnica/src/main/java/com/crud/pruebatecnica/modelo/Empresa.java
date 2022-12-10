package com.crud.pruebatecnica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @Column(name = "nit", length = 12, nullable = false)
    private String nit;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "estado", columnDefinition = "INT(1)", nullable = false)
    private Integer estado;

    public Empresa(){

    }

    public Empresa(String nit, String nombre, Integer estado) {
        this.nit = nit;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
