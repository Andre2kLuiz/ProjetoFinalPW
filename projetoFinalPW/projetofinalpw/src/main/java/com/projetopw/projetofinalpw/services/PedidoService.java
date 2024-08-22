package com.projetopw.projetofinalpw.services;

import com.projetopw.projetofinalpw.domain.Pedido;
import com.projetopw.projetofinalpw.repository.PedidoRepository;
import com.projetopw.projetofinalpw.services.generic.GenericCrudService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends GenericCrudService<Pedido, String, PedidoRepository> {
    public PedidoService(PedidoRepository repository) {
        super(repository);
    }
}
