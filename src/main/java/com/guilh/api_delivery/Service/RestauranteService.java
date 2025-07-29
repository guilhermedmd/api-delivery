package com.guilh.api_delivery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilh.api_delivery.Model.Restaurante;

public interface RestauranteService {

    public Restaurante cadastrarCliente(Restaurante restaurante);

    public Restaurante editarRestaurante(Restaurante restaurante, Long id);

    public Restaurante buscarRestaurantePorId(Long id);

    public List<Restaurante> buscarRestaurantes();

    public void deletarRestaurante(Long id);
    
}
