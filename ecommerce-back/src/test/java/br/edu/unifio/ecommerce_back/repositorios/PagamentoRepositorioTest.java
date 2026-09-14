package br.edu.unifio.ecommerce_back.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce_back.entidades.Pagamento;

@SpringBootTest 
public class PagamentoRepositorioTest {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Test 
    public void deveBuscarUmPagamentoPorId(){
        Pagamento pagamento = pagamentoRepositorio.findById(Integer.parseInt("2")).orElseThrow();

        assertNotNull(pagamento);
        assertEquals(3499.90, pagamento.getValor().doubleValue());
    }

}
