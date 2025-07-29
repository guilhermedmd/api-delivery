package com.guilh.api_delivery.Service.ServiceImp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Restaurante;
import com.guilh.api_delivery.Repository.RestauranteRepository;
import com.guilh.api_delivery.Service.RestauranteService;

@Service
public class RestauranteImp implements RestauranteService{

    RestauranteRepository restauranteRepository;

    public RestauranteImp(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public Restaurante cadastrarCliente(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante editarRestaurante(Restaurante restaurante, Long id) {
        restauranteRepository.findById(id).map(r -> {
            r.setCnpj(restaurante.getCnpj());
            r.setEndereco(restaurante.getEndereco());
            r.setNome(restaurante.getNome());
            r.setTelefone(restaurante.getTelefone());
            restauranteRepository.save(r);
            return r;
        }).orElseThrow(() -> new NoSuchElementException("Nenhum restaurante encontrado"));
        return restaurante;
    }

    @Override
    public Restaurante buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Nenhum restaurante encontrado"));
    }

    @Override
    public List<Restaurante> buscarRestaurantes() { 
        return restauranteRepository.findAll();
    }

    @Override
    public void deletarRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
    
}
