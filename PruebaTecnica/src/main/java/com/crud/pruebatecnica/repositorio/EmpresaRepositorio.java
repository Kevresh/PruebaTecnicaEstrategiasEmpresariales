package com.crud.pruebatecnica.repositorio;

import com.crud.pruebatecnica.modelo.Empresa;
import com.crud.pruebatecnica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, String> {

}
