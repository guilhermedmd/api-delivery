package com.guilh.api_delivery.Service.ServiceImp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Pedido;
import com.guilh.api_delivery.Repository.PedidoRepository;
import com.guilh.api_delivery.Service.PedidoService;

@Service
public class PedidoImp implements PedidoService{

    private PedidoRepository pedidoRepository;

    public PedidoImp(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido cadastrarPedido(Pedido newPedido) {
        return pedidoRepository.save(newPedido);
    }

    @Override
    public Pedido editarPedido(Pedido editPedido, Long codPedido) {
        pedidoRepository.findById(codPedido).map(p -> {
            p.setCliente(editPedido.getCliente());
            p.setDescricao(editPedido.getDescricao());
            p.setEntregador(editPedido.getEntregador());
            p.setRestaurante(editPedido.getRestaurante());
            p.setValor(editPedido.getValor());
            pedidoRepository.save(p);
            return p;
        }).orElseThrow(() -> new NoSuchElementException("Pedido não encontrado"));
        return editPedido;
    }

    @Override
    public Pedido buscarPedidoPorId(Long codPedido) {
        return pedidoRepository.findById(codPedido).orElseThrow(() -> new NoSuchElementException("Pedido não encontrado"));
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public void deletarPedido(Long codPedido) {
        pedidoRepository.deleteById(codPedido);
    }
    
}
