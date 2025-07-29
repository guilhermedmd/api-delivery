package com.guilh.api_delivery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Cliente;
import com.guilh.api_delivery.Repository.ClienteRepository;

public interface ClienteService {


public Cliente cadastrarCliente(Cliente newCliente);

public Cliente editarCliente(Cliente editCliente, Long id);

public Cliente buscarClientePorId(Long id);

public List<Cliente> mostrarClientes();

public void deletarCliente(Long id);
}
