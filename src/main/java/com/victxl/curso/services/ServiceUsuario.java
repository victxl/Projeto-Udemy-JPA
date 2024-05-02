package com.victxl.curso.services;

import com.victxl.curso.entities.Usuario;
import com.victxl.curso.repositories.RepositoryUsuario;
import com.victxl.curso.services.exceptions.DatabaseException;
import com.victxl.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositoryUsuario repository;
    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        try {
            Usuario usuario = findById(id);
            repositoryUsuario.delete(usuario);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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
