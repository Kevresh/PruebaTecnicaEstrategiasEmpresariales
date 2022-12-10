package com.crud.pruebatecnica.controlador;

import com.crud.pruebatecnica.modelo.Empresa;
import com.crud.pruebatecnica.modelo.Rol;
import com.crud.pruebatecnica.repositorio.EmpresaRepositorio;
import com.crud.pruebatecnica.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class RolControlador {
    @Autowired
    private RolRepositorio repositorio;

    @GetMapping("/roles")
    public List<Rol> listarTodosLosRoles(){
        return repositorio.findAll();
    }
}
