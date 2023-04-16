package com.padroesprojetospringboot.service.impl;

import com.padroesprojetospringboot.model.Cliente;
import com.padroesprojetospringboot.service.ClienteService;
import org.springframework.stereotype.Service;

/**
 * Implementação da <b>Strategy</b> {@link ClieteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author agryo
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public Iterable<Cliente> buscaTodos() {
        return null;
    }

    @Override
    public Cliente buscaPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
