package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.Produtos;

@SpringBootTest 
public class ProdutoRepositorioTest {
    @Autowired 
    private ProdutoRepositorio produtoRepositorio;

    @Test
    public void deveBuscarUmProdutoPorId(){
        Produtos produtos = produtoRepositorio.findById(Integer.parseInt("2")).orElseThrow();

        assertNotNull(produtos);
        assertEquals("Notebook Lenovo", produtos.getNome());
    }

}
