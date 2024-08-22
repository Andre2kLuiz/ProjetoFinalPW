package com.projetopw.projetofinalpw.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Usuario {
    String id;
    String Senha;
    String nome;
    List<Endereco> enderecos;
    List<Pedido> pedidos;
}
