package com.victxl.curso.services;

import com.victxl.curso.entities.Usuario;
import com.victxl.curso.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositoryUsuario repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);

        return obj.get();
    }

    public Usuario insert(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        
    }
    public Usuario update(Long id, Usuario usuario) {
        Usuario entity = repository.getReferenceById(id);
        updateData(entity,usuario);
        return repository.save(entity);
    }

    private void updateData(Usuario entity, Usuario usuario) {
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setSenha(usuario.getTelefone());

    }
}
