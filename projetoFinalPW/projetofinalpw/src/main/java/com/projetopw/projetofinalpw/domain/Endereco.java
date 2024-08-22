package com.projetopw.projetofinalpw.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Endereco {
    String id;
    String cep;
    int numero;
    String rua;
    String bairro;
    String cidade;
    String estado;
}
