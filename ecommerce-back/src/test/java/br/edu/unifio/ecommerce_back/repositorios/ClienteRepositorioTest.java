package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.Clientes;

@SpringBootTest 
public class ClienteRepositorioTest {
     @Autowired 
    private ClientesRepositorio clientesRepositorio;

    @Test
    public void deveBuscarUmProdutoPorId(){
        Clientes clientes = clientesRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(clientes);
        assertEquals("Arthur", clientes.getNome());
    }
}
