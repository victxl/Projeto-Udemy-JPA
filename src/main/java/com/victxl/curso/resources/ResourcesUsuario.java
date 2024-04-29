package com.victxl.curso.resources;

import com.victxl.curso.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class ResourcesUsuario {
    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario usuario = new Usuario(null, "Maria", "maria@gmail.com", "9999-9999", "12345");
        return ResponseEntity.ok().body(usuario);
    }

}
