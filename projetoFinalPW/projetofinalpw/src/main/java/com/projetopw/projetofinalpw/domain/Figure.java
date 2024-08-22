package com.projetopw.projetofinalpw.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String informacao;
    String ano;
    Float valor;
    Float tamanho;
}
