package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.Pedido;

@SpringBootTest 
public class PedidoRepositorioTest {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClientesRepositorio clientesRepositorio;

    @Test 
    @Order (1)
    public void deveListarTodosOsPedidos() {

        List<Pedido> pedidos = pedidoRepositorio.findAll();

        assertFalse(pedidos.isEmpty());
    }

    @Test
    @Order(2)
    public void deveBuscarUmPedidoPorId() {

        Pedido pedido = pedidoRepositorio.findById(Integer.parseInt("1")).orElseThrow();

        assertNotNull(pedido);
    }

    @Test
    @Order(3)
    public void deveExcluirUmPedidoPorId() {

        Pedido pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setStatus("ABERTO");
        pedido.setValorTotal(new BigDecimal("100.00"));

        pedido.setClientes(
                clientesRepositorio.findById(Short.parseShort("1")).orElseThrow());

        pedidoRepositorio.save(pedido);

        Integer id = pedido.getId();

        pedidoRepositorio.deleteById(id);

        Optional<Pedido> pedidoExcluido = pedidoRepositorio.findById(id);

        assertTrue(pedidoExcluido.isEmpty());
    }

    @Test
    @Order(4)
    public void deveAlterarUmPedidoPorId() {

        Pedido pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setStatus("ABERTO");
        pedido.setValorTotal(new BigDecimal("100.00"));

        pedido.setClientes(
                clientesRepositorio.findById(Short.parseShort("1")).orElseThrow());

        pedidoRepositorio.save(pedido);

        pedido.setStatus("FINALIZADO");

        pedidoRepositorio.save(pedido);

        Pedido pedidoBanco = pedidoRepositorio.findById(pedido.getId()).orElseThrow();

        assertEquals("FINALIZADO", pedidoBanco.getStatus());
    }
}
