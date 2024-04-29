package com.victxl.curso.repositories;

import com.victxl.curso.entities.Categoria;
import com.victxl.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategoria extends JpaRepository<Categoria, Long> {

}
