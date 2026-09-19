package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.ecommerce_back.entidades.Categoria;

@SpringBootTest 
public class CategoriaRepositorioTests {
    @Autowired 
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    @Order (2)
    public void deveBuscarUmaCategoriaPorId(){
        Categoria categoria = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(categoria);
        assertEquals("Livros", categoria.getNome());
    }

    @Test 
    @Order (1)
    public void deveListarTodasAsCategorias(){
        List<Categoria> categorias = categoriaRepositorio.findAll();

        assertFalse(categorias.isEmpty());
    }

    @Test
    @Order (3)
    public void deveExcluirUmaCategoriaPorId(){

        Categoria categoria = new Categoria();
        categoria.setNome("nome categoria");
        categoria.setDescricao("descricao categoria");
        categoriaRepositorio.save(categoria);

        Short id = categoria.getId();
        categoriaRepositorio.deleteById(id);
        Optional<Categoria> categoriaExcluida = categoriaRepositorio.findById(id);

        assertTrue(categoriaExcluida.isEmpty());
    }

    @Test 
    @Order (4)
    public void deveAlterarUmaCategoriaPorId(){

        Categoria categoria = new Categoria();
        categoria.setNome("nome teste");
        categoria.setDescricao("descricao teste");
        categoriaRepositorio.save(categoria);
        categoria.setNome("nome alterado");
        categoria.setDescricao("descricao alterada");
        categoriaRepositorio.save(categoria);

        Categoria categoriaBanco = categoriaRepositorio.findById(categoria.getId()).orElseThrow();

        assertEquals("nome alterado", categoriaBanco.getNome());
    }
}