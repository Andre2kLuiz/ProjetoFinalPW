package com.projetopw.projetofinalpw.dto;

import com.projetopw.projetofinalpw.controller.EnderecoController;
import com.projetopw.projetofinalpw.controller.UsuarioController;
import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.domain.Pedido;
import com.projetopw.projetofinalpw.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO extends RepresentationModel<UsuarioResponseDTO> {
    String nome;
    Endereco endereco;
    List<Pedido> pedidos;
    public void addLinks(Usuario u){
        this.add(linkTo(UsuarioController.class).slash(u.getId()).withSelfRel());
        this.add(linkTo(EnderecoController.class).slash(u.getEndereco().getId()).withRel("endereco"));
    }
}
