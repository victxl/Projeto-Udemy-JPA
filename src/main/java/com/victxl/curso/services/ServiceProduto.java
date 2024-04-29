package com.victxl.curso.services;

import com.victxl.curso.entities.Produto;
import com.victxl.curso.repositories.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);

        return obj.get();
    }
}
