package com.victxl.curso.config;

import com.victxl.curso.entities.*;
import com.victxl.curso.entities.enums.StatusPedido;
import com.victxl.curso.repositories.*;
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
    @Autowired
    private RepositoryCategoria repositoryCategoria;
    @Autowired
    private RepositoryProduto repositoryProduto;
    @Autowired
    private RepositoryItemPedido repositoryItemPedido;



    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null,"Maria","maria@gmail.com","9999-8888","123456");
        Usuario u2 = new Usuario(null,"João","joao@gmail.com","88888-99999","654321");
        Usuario u3 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedido.PAGO);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2,StatusPedido.ESPERANDO_PAGAMENTO);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1,StatusPedido.ENVIADO);

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        repositoryCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
        repositoryUsuario.saveAll(Arrays.asList(u1,u2,u3));
        repositoryPedido.saveAll(Arrays.asList(o1,o2,o3));
        repositoryProduto.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        repositoryProduto.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco());
        ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco());
        ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco());
        ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco());

        repositoryItemPedido.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
        o1.setPagamento(pag1);

        repositoryPedido.save(o1);

    }
    


}
