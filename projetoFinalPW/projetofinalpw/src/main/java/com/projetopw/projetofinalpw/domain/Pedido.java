package com.projetopw.projetofinalpw.domain;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Pedido {
    String id;
    List<Figure> figures;
    Usuario usuario;
    Float valorTotal;
}
