package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.ItemPedido;

@SpringBootTest 
public class ItemPedidoRepositorioTest {
    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

     @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Test
    @Order (2)
    public void deveBuscarUmItemPedidoPorId(){
        ItemPedido itemPedido = itemPedidoRepositorio.findById(Short.parseShort("2")).orElseThrow();

        assertNotNull(itemPedido);
        assertEquals(Short.valueOf("2"), itemPedido.getPedido().getId());
        
    }

    @Test
    @Order (1)
    public void deveListarTodosOsItemPedido(){
        List<ItemPedido> itens = itemPedidoRepositorio.findAll();

        assertFalse(itens.isEmpty());
    }
    
    
    public void deveExcluirUmItemPedidoPorId(){
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(new BigDecimal("10.00"));
        itemPedido.setPedido(pedidoRepositorio.findById(Integer.parseInt("1")).orElseThrow());
        itemPedido.setProdutos(produtoRepositorio.findById(Integer.parseInt("1")).orElseThrow());
        itemPedidoRepositorio.save(itemPedido);
        Short id = itemPedido.getId();

        itemPedidoRepositorio.deleteById(id);

        Optional<ItemPedido> itemPedidoExcluido = itemPedidoRepositorio.findById(id);

        assertTrue(itemPedidoExcluido.isEmpty());
    }

    @Test
    @Order (4)
    public void deveAlterarUmItemPedidoPorId(){
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(new BigDecimal("10.00"));
        itemPedido.setPedido(pedidoRepositorio.findById(Integer.parseInt("1")).orElseThrow());
        itemPedido.setProdutos(produtoRepositorio.findById(Integer.parseInt("1")).orElseThrow());
        itemPedidoRepositorio.save(itemPedido);
        itemPedido.setQuantidade(5);
        itemPedidoRepositorio.save(itemPedido);
        ItemPedido itemPedidoBanco =itemPedidoRepositorio.findById(itemPedido.getId()).orElseThrow();

        assertEquals(5, itemPedidoBanco.getQuantidade());
    }

}
