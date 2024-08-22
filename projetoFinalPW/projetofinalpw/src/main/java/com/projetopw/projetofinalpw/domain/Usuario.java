package com.projetopw.projetofinalpw.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String senha;
    String nome;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pedido> pedidos;

    public void setEndereco(Endereco entityEndereco) {

    }
}
