package com.guilh.api_delivery.Service.ServiceImp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Cliente;
import com.guilh.api_delivery.Repository.ClienteRepository;
import com.guilh.api_delivery.Service.ClienteService;

@Service
public class ClienteImp implements ClienteService{
    
ClienteRepository clienteRepository;

public ClienteImp(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
}

public Cliente cadastrarCliente(Cliente newCliente){
    clienteRepository.save(newCliente);
    return newCliente;
}

public Cliente editarCliente(Cliente editCliente, Long id){
    clienteRepository.findById(id).map(c ->{
        c.setCpf(editCliente.getCpf());
        c.setEndereco(editCliente.getEndereco());
        c.setNome(editCliente.getNome());
        c.setTelefone(editCliente.getTelefone());
        clienteRepository.save(c);
        return c;
    }).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    return editCliente;
}

public Cliente buscarClientePorId(Long id){
    return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
}

public List<Cliente> mostrarClientes(){
    return clienteRepository.findAll();
}

public void deletarCliente(Long id){
    clienteRepository.deleteById(id);
}
}
