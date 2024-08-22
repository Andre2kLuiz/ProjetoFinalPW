package com.projetopw.projetofinalpw.services;

import com.projetopw.projetofinalpw.domain.Figure;
import com.projetopw.projetofinalpw.repository.FigureRepository;
import com.projetopw.projetofinalpw.services.generic.GenericCrudService;
import org.springframework.stereotype.Service;

@Service
public class FigureService extends GenericCrudService<Figure, String, FigureRepository> {
    public FigureService(FigureRepository repository) {
        super(repository);
    }
}
