package com.victxl.curso.services.exceptions;

public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(Object id) {
        super("Recurso não encontrado: Id = " + id);
    }

}
