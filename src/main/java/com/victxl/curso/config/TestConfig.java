package com.victxl.curso.config;

import com.victxl.curso.entities.Usuario;
import com.victxl.curso.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null,"Maria","maria@gmail.com","9999-8888","123456");
        Usuario u2 = new Usuario(null,"João","joao@gmail.com","88888-99999","654321");
        Usuario u3 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        repositoryUsuario.saveAll(Arrays.asList(u1,u2,u3));
    }


}
