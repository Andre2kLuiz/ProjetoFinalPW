package com.projetopw.projetofinalpw.controller;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.dto.EnderecoRequestDTO;
import com.projetopw.projetofinalpw.dto.EnderecoResponseDTO;
import com.projetopw.projetofinalpw.services.EnderecoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/enderecos/")
@AllArgsConstructor
public class EnderecoController {
    private final EnderecoService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> create(@RequestBody EnderecoRequestDTO endereco){
        Endereco created = service.create(convertToEntity(endereco));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping
    public Page<EnderecoResponseDTO> listAll(Pageable pageable){
        Page<Endereco> usuariosPage = service.listAll(pageable);
        return usuariosPage.map(this::convertToDto);
    }

    @GetMapping("{id}")
    public EnderecoResponseDTO listById(@PathVariable("id") String id){
        Endereco e = service.listById(id);
        EnderecoResponseDTO dto = mapper.map(e, EnderecoResponseDTO.class);
        return dto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoResponseDTO> update(@PathVariable("id") String id, @RequestBody EnderecoRequestDTO requestDTO){
        try{
            Endereco e = service.listById(id);
        }catch (Exception e){
            return this.create(requestDTO);
        }

        Endereco updated = service.update(mapper.map(requestDTO,Endereco.class),id);
        return ResponseEntity.ok(convertToDto(updated));
    }

    private EnderecoResponseDTO convertToDto(Endereco created){
        EnderecoResponseDTO enderecoResponseDTO = mapper.map(created, EnderecoResponseDTO.class);
        return enderecoResponseDTO;
    }

    private Endereco convertToEntity(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco entityEndereco = mapper.map(enderecoRequestDTO, Endereco.class);
        return entityEndereco;
    }
}
