package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.unifio.ecommerce_back.entidades.Produtos;
import org.springframework.data.domain.Sort;

@SpringBootTest 
public class ProdutoRepositorioTest {
    @Autowired 
    private ProdutoRepositorio produtoRepositorio;
    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    @Test
    @Order (2)
    public void deveBuscarUmProdutoPorId(){
        Produtos produtos = produtoRepositorio.findById(Integer.parseInt("2")).orElseThrow();

        assertNotNull(produtos);
        assertEquals("Notebook Lenovo", produtos.getNome());
        
    }

    @Test
    @Order (1)
    public void deveListarTodosOsProdutos(){
        List<Produtos> produtos = produtoRepositorio.findAll(Sort.by("nome"));

        assertEquals(5, produtos.size());
        assertEquals("Codigo Limpo", produtos.get(0).getNome());
        assertEquals("Fone Bluetooth", produtos.get(1).getNome());

    }

    @Test
    @Order (3)
    public void deveExcluirUmProdutoPorId(){

        Produtos produto = new Produtos();
        produto.setNome("Nome Teste");
        produto.setDescricao("Descriçao teste");
        produto.setEstoque(Short.parseShort("1"));
        produto.setPreco(new BigDecimal("1.00"));
        produto.setCategoria(categoriaRepositorio.findById(Short.parseShort("1")).orElseThrow());
        produtoRepositorio.save(produto);

        Integer id = produto.getId();

        produtoRepositorio.deleteById(id);

        Optional<Produtos> produtoExcluido = produtoRepositorio.findById(id);

        assertTrue(produtoExcluido.isEmpty());
    }

    @Test
    @Order (4)
    public void deveAlterarUmProdutoPorId(){

        Produtos produto = new Produtos();

        produto.setNome("Nome Teste");
        produto.setDescricao("Descrição teste");
        produto.setEstoque(Short.parseShort("1"));
        produto.setPreco(new BigDecimal("1.00"));
        produto.setCategoria(categoriaRepositorio.findById(Short.parseShort("1")).orElseThrow());
        produtoRepositorio.save(produto);
        produto.setNome("Nome Alterado");
        produtoRepositorio.save(produto);

        Produtos produtoBanco = produtoRepositorio.findById(produto.getId()).orElseThrow();

        assertEquals("Nome Alterado", produtoBanco.getNome());
    }
}
