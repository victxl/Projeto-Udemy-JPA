package com.victxl.curso.resources;

import com.victxl.curso.entities.Usuario;
import com.victxl.curso.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class ResourcesUsuario {
    @Autowired
    private ServiceUsuario service;
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

}
