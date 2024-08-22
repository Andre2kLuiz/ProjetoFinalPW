package com.projetopw.projetofinalpw.services;

import org.springframework.stereotype.Service;

import com.projetopw.projetofinalpw.domain.Usuario;
import com.projetopw.projetofinalpw.repository.UsuarioRepository;
import com.projetopw.projetofinalpw.services.generic.GenericCrudService;

@Service
public class UsuarioService extends GenericCrudService<Usuario, String, UsuarioRepository>{
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }
}
