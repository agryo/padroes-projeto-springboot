package com.padroesprojetospringboot.service.impl;

import com.padroesprojetospringboot.model.Cliente;
import com.padroesprojetospringboot.model.Endereco;
import com.padroesprojetospringboot.model.repository.ClienteRepository;
import com.padroesprojetospringboot.model.repository.EnderecoRepository;
import com.padroesprojetospringboot.service.ClienteService;
import com.padroesprojetospringboot.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClieteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author agryo
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    @Override
    public Iterable<Cliente> buscaTodos() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente buscaPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }
    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }
    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar cliente por Id, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    private void salvarClienteComCep(Cliente cliente) {
        // Verifica se o endereço do cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista o endereço, integrar o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir o cliente, vinculando o endereço (novo ou existente).
        clienteRepository.save(cliente);
    }
}
