package com.padroesprojetospringboot.service;

import com.padroesprojetospringboot.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se nescessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author agryo
 */
public interface ClienteService {
    Iterable<Cliente> buscaTodos();
    Cliente buscaPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
