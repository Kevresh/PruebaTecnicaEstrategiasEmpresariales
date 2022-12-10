package com.crud.pruebatecnica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @Column(name = "id", columnDefinition = "INT(2)", nullable = false)
    private Integer id;

    @Column(name = "rol", length = 50, nullable = false)
    private String rol;

    @Column(name = "estado", columnDefinition = "INT(1)", nullable = false)
    private Integer estado;

    public Rol(){

    }

    public Rol(Integer id, String rol, Integer estado) {
        this.id = id;
        this.rol = rol;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setNit(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
