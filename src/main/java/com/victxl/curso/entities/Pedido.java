package com.victxl.curso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.victxl.curso.entities.enums.StatusPedido;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;


    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Usuario cliente;

    public Pedido() {
    }

    public Pedido(Long id, Instant momento, Usuario cliente, StatusPedido statusPedido) {
        this.id = id;
        this.momento = momento;
        this.cliente = cliente;
        setStatusPedido(statusPedido);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) {
            this.statusPedido = statusPedido.getCod();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
