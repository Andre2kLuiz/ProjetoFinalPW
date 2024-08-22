package com.projetopw.projetofinalpw.controller;

import com.projetopw.projetofinalpw.domain.Figure;
import com.projetopw.projetofinalpw.dto.FigureRequestDTO;
import com.projetopw.projetofinalpw.dto.FigureResponseDTO;
import com.projetopw.projetofinalpw.services.FigureService;
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
@RequestMapping("/figures/")
@AllArgsConstructor
public class FigureController {
    private final FigureService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<FigureResponseDTO> create(@RequestBody FigureRequestDTO figure){
        Figure created = service.create(convertToEntity(figure));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping
    public Page<FigureResponseDTO> listAll(Pageable pageable){
        Page<Figure> figuresPage = service.listAll(pageable);
        return figuresPage.map(this::convertToDto);
    }

    @GetMapping("{id}")
    public FigureResponseDTO listById(@PathVariable("id") String id){
        Figure f = service.listById(id);
        FigureResponseDTO dto = mapper.map(f, FigureResponseDTO.class);
        return dto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<FigureResponseDTO> update(@PathVariable("id") String id, @RequestBody FigureRequestDTO requestDTO){
        try{
            Figure f = service.listById(id);
        }catch (Exception e){
            return this.create(requestDTO);
        }

        Figure updated = service.update(mapper.map(requestDTO,Figure.class),id);
        return ResponseEntity.ok(convertToDto(updated));
    }

    private FigureResponseDTO convertToDto(Figure created){
        return mapper.map(created, FigureResponseDTO.class);
    }

    private Figure convertToEntity(FigureRequestDTO figureRequestDTO) {
        return mapper.map(figureRequestDTO, Figure.class);
    }
}
