package com.guilh.api_delivery.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilh.api_delivery.Model.Pedido;
import com.guilh.api_delivery.Service.PedidoService;




@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("editar/{codPedido}")
    public ResponseEntity<Pedido> editarPedido(@PathVariable Long codPedido, @RequestBody Pedido pedido) {
        pedidoService.editarPedido(pedido, codPedido);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/buscar/{codPedido}")
    public Pedido buscarPedido(@PathVariable Long codPedido) {
        return pedidoService.buscarPedidoPorId(codPedido);
    }

    @GetMapping("/buscar")
    public List<Pedido> buscarPedidos() {
        return pedidoService.buscarPedidos();
    }

    @DeleteMapping("/deletar/{codPedido}")
    public void deletarPedido(@PathVariable Long codPedido){
        pedidoService.deletarPedido(codPedido);
    }
    
    
    
}
