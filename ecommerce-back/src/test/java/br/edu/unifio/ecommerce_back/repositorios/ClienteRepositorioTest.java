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

import br.edu.unifio.ecommerce_back.entidades.Clientes;

@SpringBootTest 
public class ClienteRepositorioTest {
     @Autowired 
    private ClientesRepositorio clientesRepositorio;

    @Test
    @Order (2)
    public void deveBuscarUmProdutoPorId(){
        Clientes clientes = clientesRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(clientes);
        assertEquals("Arthur", clientes.getNome());
    }

    @Test
    @Order (1)
    public void deveListarTodosOsClientes(){
        List<Clientes> clientes = clientesRepositorio.findAll();

        assertFalse(clientes.isEmpty());
    }

    @Test
    @Order (3)
    public void deveExcluirUmClientePorId(){

        Clientes cliente = new Clientes();

        cliente.setNome("Nome Teste");
        cliente.setEmail("teste@email.com");
        cliente.setTelefone(99999999);

        clientesRepositorio.save(cliente);

        Short id = cliente.getId();

        clientesRepositorio.deleteById(id);

        Optional<Clientes> clienteExcluido = clientesRepositorio.findById(id);

        assertTrue(clienteExcluido.isEmpty());
    }
    
    @Test
    @Order (4)
    public void deveAlterarUmClientePorId(){
        Clientes cliente = new Clientes();

        cliente.setNome("Nome Teste");
        cliente.setEmail("teste@email.com");
        cliente.setTelefone(99999999);

        clientesRepositorio.save(cliente);

        cliente.setNome("Nome Alterado");

        clientesRepositorio.save(cliente);

        Clientes clienteBanco = clientesRepositorio.findById(cliente.getId()).orElseThrow();

        assertEquals("Nome Alterado", clienteBanco.getNome());
    }
}
