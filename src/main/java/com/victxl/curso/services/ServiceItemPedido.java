package com.victxl.curso.services;

import com.victxl.curso.entities.ItemPedido;
import com.victxl.curso.repositories.RepositoryItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceItemPedido {

    @Autowired
    private RepositoryItemPedido repository;

    public List<ItemPedido> findAll() {
        return repository.findAll();
    }

    public ItemPedido findById(Long id) {
        Optional<ItemPedido> obj = repository.findById(id);

        return obj.get();
    }
}
