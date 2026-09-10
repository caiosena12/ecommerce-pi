package br.edu.unifio.ecommerce_back.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.ecommerce_back.entidades.ItemPedido;

public interface ItemPedidoRepositorio extends JpaRepository <ItemPedido, Short> {

}
