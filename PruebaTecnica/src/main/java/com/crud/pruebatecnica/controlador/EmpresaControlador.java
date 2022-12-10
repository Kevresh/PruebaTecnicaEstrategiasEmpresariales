package com.crud.pruebatecnica.controlador;

import com.crud.pruebatecnica.modelo.Empresa;
import com.crud.pruebatecnica.modelo.Usuario;
import com.crud.pruebatecnica.repositorio.EmpresaRepositorio;
import com.crud.pruebatecnica.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpresaControlador {
    @Autowired
    private EmpresaRepositorio repositorio;

    @GetMapping("/empresas")
    public List<Empresa> listarTodasLasEmpresas(){
        return repositorio.findAll();
    }
}
