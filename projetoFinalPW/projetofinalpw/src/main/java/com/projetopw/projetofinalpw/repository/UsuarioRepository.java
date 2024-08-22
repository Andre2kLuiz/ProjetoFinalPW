package com.projetopw.projetofinalpw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetopw.projetofinalpw.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
}
