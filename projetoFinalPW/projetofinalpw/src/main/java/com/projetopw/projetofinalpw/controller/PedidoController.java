package com.projetopw.projetofinalpw.controller;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.domain.Figure;
import com.projetopw.projetofinalpw.domain.Pedido;
import com.projetopw.projetofinalpw.domain.Usuario;
import com.projetopw.projetofinalpw.dto.PedidoRequestDTO;
import com.projetopw.projetofinalpw.dto.PedidoResponseDTO;
import com.projetopw.projetofinalpw.dto.UsuarioRequestDTO;
import com.projetopw.projetofinalpw.dto.UsuarioResponseDTO;
import com.projetopw.projetofinalpw.services.PedidoService;
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
@RequestMapping("/pedidos/")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> create(@RequestBody PedidoRequestDTO pedido){
        Pedido created = service.create(convertToEntity(pedido));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping
    public Page<PedidoResponseDTO> listAll(Pageable pageable){
        Page<Pedido> pedidosPage = service.listAll(pageable);
        return pedidosPage.map(this::convertToDto);
    }

    @GetMapping("{id}")
    public PedidoResponseDTO listById(@PathVariable("id") String id){
        Pedido p = service.listById(id);
        PedidoResponseDTO dto = mapper.map(p, PedidoResponseDTO.class);
        return dto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> update(@PathVariable("id") String id, @RequestBody PedidoRequestDTO requestDTO){
        try{
            Pedido p = service.listById(id);
        }catch (Exception e){
            return this.create(requestDTO);
        }

        Pedido pedidoUpdated = service.update(mapper.map(requestDTO,Pedido.class),id);
        return ResponseEntity.ok(convertToDto(pedidoUpdated));
    }

    private PedidoResponseDTO convertToDto(Pedido created){
        PedidoResponseDTO pedidoResponseDTO = mapper.map(created, PedidoResponseDTO.class);
        return pedidoResponseDTO;
    }

    private Pedido convertToEntity(PedidoRequestDTO pedidoRequestDTO) {
        Pedido entityPedido = mapper.map(pedidoRequestDTO, Pedido.class);
        Usuario entityUsuario = mapper.map(pedidoRequestDTO.getUsuario(),Usuario.class);
        List<Figure> figures = mapper.map(pedidoRequestDTO.getFigures(), List.class);
        entityPedido.setUsuario(entityUsuario);
        entityPedido.setFigures(figures);
        return entityPedido;
    }
}
