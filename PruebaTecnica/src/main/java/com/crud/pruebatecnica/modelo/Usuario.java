package com.crud.pruebatecnica.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "cedula", length = 12, nullable = false)
    private String cedula;
    @Column(name = "primernombre", length = 12, nullable = false)
    private String primernombre;

    @Column(name = "segundonombre", length = 50)
    private String segundonombre;

    @Column(name = "primerapellido", length = 50, nullable = false)
    private String primerapellido;

    @Column(name = "segundoapellido", length = 50, nullable = false)
    private String segundoapellido;

    @Column(name = "clave", length = 150, nullable = false)
    private String clave;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nitempresa", columnDefinition = "VARCHAR(12)")
    private Empresa nitempresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol", columnDefinition = "INT(2)")
    private Rol rol;

    @Column(name = "estado", nullable = false, columnDefinition = "INT(1)")
    private Integer estado;

    public Usuario(){

    }

    public Usuario(String cedula, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String clave, String email, Empresa nitempresa, Rol rol, Integer estado) {
        this.cedula = cedula;
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.clave = clave;
        this.email = email;
        this.nitempresa = nitempresa;
        this.rol = rol;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Empresa getNitempresa() {
        return nitempresa;
    }

    public void setNitempresa(Empresa nitempresa) {
        this.nitempresa = nitempresa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
