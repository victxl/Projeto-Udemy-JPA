package com.victxl.curso.repositories;

import com.victxl.curso.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryItemPedido extends JpaRepository<ItemPedido, Long> {

}
