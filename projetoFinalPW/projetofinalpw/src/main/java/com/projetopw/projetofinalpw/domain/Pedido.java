package com.projetopw.projetofinalpw.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToMany
    List<Figure> figures;
    @ManyToOne
    Usuario usuario;
    Float valorTotal;
}
