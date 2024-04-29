package com.victxl.curso.repositories;

import com.victxl.curso.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPedido extends JpaRepository<Pedido, Long> {

}
