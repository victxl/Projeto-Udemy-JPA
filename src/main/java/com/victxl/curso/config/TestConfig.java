package com.victxl.curso.config;

import com.victxl.curso.entities.Pedido;
import com.victxl.curso.entities.Usuario;
import com.victxl.curso.entities.enums.StatusPedido;
import com.victxl.curso.repositories.RepositoryPedido;
import com.victxl.curso.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private RepositoryUsuario repositoryUsuario;
    @Autowired
    private RepositoryPedido repositoryPedido;



    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null,"Maria","maria@gmail.com","9999-8888","123456");
        Usuario u2 = new Usuario(null,"João","joao@gmail.com","88888-99999","654321");
        Usuario u3 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedido.PAGO);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2,StatusPedido.ESPERANDO_PAGAMENTO);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1,StatusPedido.ENVIADO);


        repositoryUsuario.saveAll(Arrays.asList(u1,u2,u3));
        repositoryPedido.saveAll(Arrays.asList(o1,o2,o3));
    }
    


}
