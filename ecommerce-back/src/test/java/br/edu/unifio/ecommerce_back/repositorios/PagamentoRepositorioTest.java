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

import br.edu.unifio.ecommerce_back.entidades.Pagamento;
import br.edu.unifio.ecommerce_back.entidades.Pedido;

@SpringBootTest 
public class PagamentoRepositorioTest {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClientesRepositorio clientesRepositorio;


    @Test
    @Order (1)
    public void deveListarTodosOsPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll();

        assertFalse(pagamentos.isEmpty());
    }

    @Test
    @Order(2)
    public void deveBuscarUmPagamentoPorId() {

        Pagamento pagamento = pagamentoRepositorio.findById(Integer.parseInt("1")).orElseThrow();

        assertNotNull(pagamento);
    }

    @Test
    @Order(3)
    public void deveExcluirUmPagamentoPorId() {

        Pedido pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setStatus("ABERTO");
        pedido.setValorTotal(new BigDecimal("100.00"));
        pedido.setClientes(clientesRepositorio.findById(Short.parseShort("1")).orElseThrow());
        pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();

        pagamento.setValor(new BigDecimal("100.00"));
        pagamento.setData(LocalDateTime.now());
        pagamento.setStatus("APROVADO");
        pagamento.setTipo("PIX");
        pagamento.setPedido(pedido);

        pagamentoRepositorio.save(pagamento);

        Integer id = pagamento.getId();

        pagamentoRepositorio.deleteById(id);

        Optional<Pagamento> pagamentoExcluido = pagamentoRepositorio.findById(id);

        assertTrue(pagamentoExcluido.isEmpty());
    }


    @Test 
    @Order(4)
    public void deveAlterarUmPagamentoPorId() {

        Pedido pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setStatus("ABERTO");
        pedido.setValorTotal(new BigDecimal("100.00"));
        pedido.setClientes(clientesRepositorio.findById(Short.parseShort("1")).orElseThrow());
        pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();

        pagamento.setValor(new BigDecimal("100.00"));
        pagamento.setData(LocalDateTime.now());
        pagamento.setStatus("APROVADO");
        pagamento.setTipo("PIX");
        pagamento.setPedido(pedido);

        pagamentoRepositorio.save(pagamento);
        pagamento.setStatus("CANCELADO");
        pagamentoRepositorio.save(pagamento);

        Pagamento pagamentoBanco = pagamentoRepositorio.findById(pagamento.getId()).orElseThrow();

        assertEquals("CANCELADO",pagamentoBanco.getStatus());
    }

}
