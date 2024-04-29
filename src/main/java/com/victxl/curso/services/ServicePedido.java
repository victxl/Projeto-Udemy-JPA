package com.victxl.curso.services;

import com.victxl.curso.entities.Pedido;
import com.victxl.curso.repositories.RepositoryPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePedido {

    @Autowired
    private RepositoryPedido repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repository.findById(id);

        return obj.get();
    }
}
