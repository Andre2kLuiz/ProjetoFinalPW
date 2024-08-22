package com.projetopw.projetofinalpw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FigureResponseDTO {
    String informacao;
    String ano;
    Float valor;
    Float tamanho;
}
