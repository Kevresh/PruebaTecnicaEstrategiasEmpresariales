package com.crud.pruebatecnica.controlador;

import com.crud.pruebatecnica.DTO.UsuarioDTO;
import com.crud.pruebatecnica.excepciones.ResourceNotFoundException;
import com.crud.pruebatecnica.modelo.Empresa;
import com.crud.pruebatecnica.modelo.Rol;
import com.crud.pruebatecnica.modelo.Usuario;
import com.crud.pruebatecnica.repositorio.EmpresaRepositorio;
import com.crud.pruebatecnica.repositorio.RolRepositorio;
import com.crud.pruebatecnica.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private EmpresaRepositorio repositorioEmpresa;

    @Autowired
    private RolRepositorio repositorioRol;

    //Metodo para listar todos los usuarios
    @GetMapping("/usuarios")
    public List<Usuario> listarTodosLosUsuarios(){
        return repositorio.findAll();
    }

    //Para hacer una peticion de tipo Post y guardar el usuario
    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody UsuarioDTO usuario){

        Empresa empresa = repositorioEmpresa.findById(usuario.getNitempresa()).orElseThrow();

        Rol rol = repositorioRol.findById(usuario.getRol()).orElseThrow();

        Usuario newusuario = new Usuario();
        newusuario.setNitempresa(empresa);
        newusuario.setCedula(usuario.getCedula());
        newusuario.setClave(usuario.getClave());
        newusuario.setPrimernombre(usuario.getPrimernombre());
        newusuario.setSegundonombre(usuario.getSegundonombre());
        newusuario.setPrimerapellido(usuario.getPrimerapellido());
        newusuario.setSegundoapellido(usuario.getSegundoapellido());
        newusuario.setRol(rol);
        newusuario.setEstado(usuario.getEstado());
        newusuario.setEmail(usuario.getEmail());


        return repositorio.save(newusuario);
    }

    //Metodo para buscar un Usuario por cedula
    @GetMapping("/usuarios/{cedula}")
    public ResponseEntity<Usuario>ObtenerUsuarioPorCedula(@PathVariable("cedula") String cedula){
        Usuario usuario = repositorio.findById(cedula).orElseThrow(()-> new ResourceNotFoundException(("No existe el usuario con la cedula: " + cedula)));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuarios/{cedula}")
    public ResponseEntity<Usuario>ActualizarUsuario(@PathVariable("cedula") String cedula, @RequestBody UsuarioDTO usuario){
        Usuario usuarioNew = repositorio.findById(cedula).orElseThrow(()-> new ResourceNotFoundException(("No existe el usuario con la cedula: " + cedula)));

        Rol rol = repositorioRol.findById(usuario.getRol()).orElseThrow();
        Empresa empresa = repositorioEmpresa.findById(usuario.getNitempresa()).orElseThrow();

        usuarioNew.setPrimernombre(usuario.getPrimernombre());
        usuarioNew.setSegundonombre(usuario.getSegundonombre());
        usuarioNew.setEmail(usuario.getEmail());
        usuarioNew.setRol(rol);
        usuarioNew.setClave(usuario.getClave());
        usuarioNew.setNitempresa(empresa);
        usuarioNew.setPrimerapellido(usuario.getPrimerapellido());
        usuarioNew.setSegundoapellido(usuario.getSegundoapellido());
        usuarioNew.setEstado(usuario.getEstado());

        Usuario usuarioActualizado = repositorio.save(usuarioNew);

        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/usuarios/{cedula}")
    public ResponseEntity<Map<String,Boolean>>eliminarUsuario(@PathVariable("cedula") String cedula){
        Usuario usuario = repositorio.findById(cedula).orElseThrow(()-> new ResourceNotFoundException(("No existe el usuario con la cedula: " + cedula)));

        repositorio.delete(usuario);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);

        return ResponseEntity.ok(respuesta);
    }
}
