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

import com.guilh.api_delivery.Model.Restaurante;
import com.guilh.api_delivery.Service.RestauranteService;




@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    
    private RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Restaurante> cadastrarRestaurante(@RequestBody Restaurante restaurante) {
        restauranteService.cadastrarCliente(restaurante);
        return ResponseEntity.ok(restaurante);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Restaurante> editarRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        restauranteService.editarRestaurante(restaurante, id);
        return ResponseEntity.ok(restaurante);
    }

    @GetMapping("/{id}")
    public Restaurante buscarRestaurante(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.buscarRestaurantePorId(id);
        return restaurante;
    }

    @GetMapping("/buscar")
    public List<Restaurante> buscarRestaurantes() {
        return restauranteService.buscarRestaurantes();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarRestaurante(@PathVariable Long id){
        restauranteService.deletarRestaurante(id);
    }
    
    
    
}
