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

import com.guilh.api_delivery.Model.Cliente;
import com.guilh.api_delivery.Service.ClienteService;




@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.editarCliente(cliente, id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/buscarPorId/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return cliente;
    }

    @GetMapping("/buscar")
    public List<Cliente> buscarClientes() {
        return clienteService.mostrarClientes();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
    
    
    
}
