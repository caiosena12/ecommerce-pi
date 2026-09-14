package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.Pedido;

@SpringBootTest 
public class PedidoRepositorioTest {
    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Test 
    public void deveBuscarUmPrdidoPorId(){
        Pedido pedido = pedidoRepositorio.findById(Integer.parseInt("2")).orElseThrow();

        assertNotNull(pedido);
        assertEquals(Short.valueOf("2"), pedido.getClientes().getId());
    }

}
