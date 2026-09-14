package br.edu.unifio.ecommerce_back.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.ecommerce_back.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository <Pedido, Integer> {

}
