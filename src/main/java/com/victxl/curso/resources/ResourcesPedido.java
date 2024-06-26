package com.victxl.curso.resources;

import com.victxl.curso.entities.Pedido;
import com.victxl.curso.services.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class ResourcesPedido {
    @Autowired
    private ServicePedido service;
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

}
