package com.victxl.curso.services;

import com.victxl.curso.entities.Categoria;
import com.victxl.curso.repositories.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCategoria {

    @Autowired
    private RepositoryCategoria repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);

        return obj.get();
    }
}
