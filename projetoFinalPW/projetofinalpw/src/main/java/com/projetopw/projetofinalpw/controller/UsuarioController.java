package com.projetopw.projetofinalpw.controller;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.domain.Pedido;
import com.projetopw.projetofinalpw.domain.Usuario;
import com.projetopw.projetofinalpw.dto.UsuarioRequestDTO;
import com.projetopw.projetofinalpw.dto.UsuarioResponseDTO;
import com.projetopw.projetofinalpw.services.PedidoService;
import com.projetopw.projetofinalpw.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario/")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO usuario){
        Usuario created = service.create(convertToEntity(usuario));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping
    public Page<UsuarioResponseDTO> listAll(Pageable pageable){
        Page<Usuario> usuariosPage = service.listAll(pageable);
        return usuariosPage.map(this::convertToDto);
    }

    @GetMapping("{id}")
    public UsuarioResponseDTO listById(@PathVariable("id") String id){
        Usuario u = service.listById(id);
        UsuarioResponseDTO dto = mapper.map(u, UsuarioResponseDTO.class);
        return dto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable("id") String id, @RequestBody UsuarioRequestDTO requestDTO){
        try{
            Usuario u = service.listById(id);
        }catch (Exception e){
            return this.create(requestDTO);
        }

        Usuario usuarioUpdated = service.update(mapper.map(requestDTO,Usuario.class),id);
        return ResponseEntity.ok(convertToDto(usuarioUpdated));
    }

    private UsuarioResponseDTO convertToDto(Usuario created){
        UsuarioResponseDTO usuarioResponseDTO = mapper.map(created, UsuarioResponseDTO.class);
        return usuarioResponseDTO;
    }

    private Usuario convertToEntity(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario entityUsuario = mapper.map(usuarioRequestDTO, Usuario.class);
        Endereco entityEndereco = mapper.map(usuarioRequestDTO.getEndereco(), Endereco.class);
        List<Pedido> entityPedido = mapper.map(usuarioRequestDTO.getPedidos(),List.class);
        entityUsuario.setEndereco(entityEndereco);
        entityUsuario.setPedidos(entityPedido);
        return entityUsuario;
    }

}
