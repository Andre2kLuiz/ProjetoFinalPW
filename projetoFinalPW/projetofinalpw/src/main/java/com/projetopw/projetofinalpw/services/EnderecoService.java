package com.projetopw.projetofinalpw.services;

import com.projetopw.projetofinalpw.domain.Endereco;
import com.projetopw.projetofinalpw.repository.EnderecoRepository;
import com.projetopw.projetofinalpw.services.generic.GenericCrudService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericCrudService<Endereco, String, EnderecoRepository> {
    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
