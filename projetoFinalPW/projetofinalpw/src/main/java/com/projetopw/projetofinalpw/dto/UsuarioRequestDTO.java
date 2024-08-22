package com.projetopw.projetofinalpw.dto;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    String nome;
    Endereco endereco;
    List<Pedido> pedidos;
}
