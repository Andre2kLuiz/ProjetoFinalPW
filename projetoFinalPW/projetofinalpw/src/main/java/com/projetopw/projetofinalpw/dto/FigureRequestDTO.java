package com.projetopw.projetofinalpw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FigureRequestDTO {
    String informacao;
    String ano;
    Float valor;
    Float tamanho;
}
