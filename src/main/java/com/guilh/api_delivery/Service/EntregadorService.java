package com.guilh.api_delivery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Entregador;

public interface EntregadorService {
    
    public Entregador cadastrarEntregador(Entregador newEntregador);

    public Entregador editarEntregador(Entregador editEntregador, Long id);

    public Entregador buscasEntregadorPorId(Long id);

    public List<Entregador> buscarEntregadores();

    public void deletarEntregador(Long id);
}
