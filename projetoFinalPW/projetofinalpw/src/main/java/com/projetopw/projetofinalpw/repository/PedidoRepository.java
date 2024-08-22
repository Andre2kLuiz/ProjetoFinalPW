package com.projetopw.projetofinalpw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetopw.projetofinalpw.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{
    
}
