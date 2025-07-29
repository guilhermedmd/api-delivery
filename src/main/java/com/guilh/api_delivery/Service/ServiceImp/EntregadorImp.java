package com.guilh.api_delivery.Service.ServiceImp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Entregador;
import com.guilh.api_delivery.Repository.EntregadorRepository;
import com.guilh.api_delivery.Service.EntregadorService;

@Service
public class EntregadorImp implements EntregadorService{

    private EntregadorRepository entregadorRepository;

    public EntregadorImp(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    @Override
    public Entregador cadastrarEntregador(Entregador newEntregador) {
        return entregadorRepository.save(newEntregador);
    }

    @Override
    public Entregador editarEntregador(Entregador editEntregador, Long id) {
        entregadorRepository.findById(id).map(e ->{
            e.setNome(editEntregador.getNome());
            e.setEndereco(editEntregador.getEndereco());
            e.setTelefone(editEntregador.getTelefone());
            e.setTipoVeiculo(editEntregador.getTipoVeiculo());
            entregadorRepository.save(e);
            return e;
        }).orElseThrow(() -> new NoSuchElementException("Entregador não encontrado"));
        return editEntregador;
    }

    @Override
    public Entregador buscasEntregadorPorId(Long id) {
        return entregadorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Nenhum entregador encontrado"));
    }

    @Override
    public List<Entregador> buscarEntregadores() {
        return entregadorRepository.findAll();
    }

    @Override
    public void deletarEntregador(Long id) {
        entregadorRepository.deleteById(id);
    }
    
}
