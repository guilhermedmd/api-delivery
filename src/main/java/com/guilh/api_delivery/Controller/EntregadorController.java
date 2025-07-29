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

import com.guilh.api_delivery.Model.Entregador;
import com.guilh.api_delivery.Service.EntregadorService;




@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
    
    private EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Entregador> cadastrarEntregador(@RequestBody Entregador entregador) {
        entregadorService.cadastrarEntregador(entregador);
        return ResponseEntity.ok(entregador);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Entregador> editarEntregador(@PathVariable Long id, @RequestBody Entregador entregador) {
        entregadorService.editarEntregador(entregador, id);
        return ResponseEntity.ok(entregador);
    }

    @GetMapping("/buscar/{id}")
    public Entregador buscarEntregador(@PathVariable Long id) {
        return entregadorService.buscasEntregadorPorId(id);
    }

    @GetMapping("/buscar")
    public List<Entregador> buscarEntregadores() {
        return entregadorService.buscarEntregadores();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEntregador(@PathVariable Long id){
        entregadorService.deletarEntregador(id);
    }
    
    

    
}
