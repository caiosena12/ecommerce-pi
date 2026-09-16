package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.ItemPedido;

@SpringBootTest 
public class ItemPedidoRepositorioTest {
    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Test
    public void deveBuscarUmItemPedidoPorId(){
        ItemPedido itemPedido = itemPedidoRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(itemPedido);
        assertEquals(Short.valueOf("2"), itemPedido.getPedido().getId());
        
    }


}
