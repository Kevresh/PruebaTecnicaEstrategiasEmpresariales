package com.crud.pruebatecnica.repositorio;

import com.crud.pruebatecnica.modelo.Empresa;
import com.crud.pruebatecnica.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
}
