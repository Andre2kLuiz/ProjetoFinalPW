package com.projetopw.projetofinalpw.dto;

import com.projetopw.projetofinalpw.domain.Figure;
import com.projetopw.projetofinalpw.domain.Usuario;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    List<Figure> figures;
    Usuario usuario;
    Float valorTotal;
}
