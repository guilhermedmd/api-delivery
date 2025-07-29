package com.guilh.api_delivery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Pedido;

public interface PedidoService {

    public Pedido cadastrarPedido(Pedido newPedido);

    public Pedido editarPedido(Pedido editPedido, Long codPedido);

    public Pedido buscarPedidoPorId(Long codPedido);

    public List<Pedido> buscarPedidos();

    public void deletarPedido(Long codPedido);
    
}
