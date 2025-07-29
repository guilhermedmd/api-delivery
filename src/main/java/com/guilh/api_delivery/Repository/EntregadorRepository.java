package com.guilh.api_delivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilh.api_delivery.Model.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long>{
    
}
