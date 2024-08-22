package com.projetopw.projetofinalpw.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Figure {
    String id;
    String informacao;
    String ano;
    Float valor;
    Float tamanho;
}
