package com.oticasertaneja.otica_sertaneja.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oticasertaneja.otica_sertaneja.Entity.Cliente.Cliente;
import com.oticasertaneja.otica_sertaneja.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
@Transactional(readOnly = true)
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
    private static final String CLIENTE_NAO_ENCONTRADO = "Cliente com ID %d não encontrado.";
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = false)
    public Cliente salva(@Valid Cliente cliente){

        if(clienteRepository.existsByCpf(cliente.getCpf())){
            throw new IllegalArgumentException("Já existe um cliente com o CPF fornecido.");
        }
        cliente.setCriadoEm(LocalDateTime.now());
        cliente.setAtivo(true);
        logger.info("Salvando um novo cliente: {}",cliente);
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = false)
    public Cliente editar(Long id,Cliente clienteAtualizado){

        Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));

        if(!clienteExistente.getCpf().equals(clienteAtualizado.getCpf())
        && clienteRepository.existsByCpf(clienteAtualizado.getCpf())){
            throw new IllegalArgumentException("O CPF fornecido já está associado a outro cliente.");
        }

        if(clienteAtualizado.getNome() != null) clienteExistente.setNome(clienteAtualizado.getNome());
        if(clienteAtualizado.getCpf() != null) clienteExistente.setCpf(clienteAtualizado.getCpf());
        if(clienteAtualizado.getTipoOculos() != null) clienteExistente.setTipoOculos(clienteAtualizado.getTipoOculos());
        if(clienteAtualizado.getAtivo() != null) clienteExistente.setAtivo(clienteAtualizado.getAtivo());
        if(clienteAtualizado.getDataValidadeOculos() != null) clienteExistente.setDataValidadeOculos(clienteAtualizado.getDataValidadeOculos());
        if(clienteAtualizado.getQuantidadeParcelas() != null) clienteExistente.setQuantidadeParcelas(clienteAtualizado.getQuantidadeParcelas());
        if(clienteAtualizado.getParcelasPagas() != null) clienteExistente.setParcelasPagas(clienteAtualizado.getParcelasPagas());
        if(clienteAtualizado.getContatoWhatsapp() != null) clienteExistente.setContatoWhatsapp(clienteAtualizado.getContatoWhatsapp());
        if(clienteAtualizado.getDataNascimento() != null) clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
        if(clienteAtualizado.getAfiliado() != null) clienteExistente.setAfiliado(clienteAtualizado.getAfiliado());
        if(clienteAtualizado.getCep() != null) clienteExistente.setCep(clienteAtualizado.getCep());
        if(clienteAtualizado.getRua() != null)clienteExistente.setRua(clienteAtualizado.getRua());
        if(clienteAtualizado.getNumeroCasa() != null) clienteExistente.setNumeroCasa(clienteAtualizado.getNumeroCasa());
        if(clienteAtualizado.getBairro() != null) clienteExistente.setBairro(clienteAtualizado.getBairro());
        if(clienteAtualizado.getCidade() != null) clienteExistente.setCidade(clienteAtualizado.getCidade());
        if(clienteAtualizado.getUf() != null) clienteExistente.setUf(clienteAtualizado.getUf());
        if(clienteAtualizado.getClienteDesde() != null) clienteExistente.setClienteDesde(clienteAtualizado.getClienteDesde());
        if(clienteAtualizado.getSituacao() != null)clienteExistente.setSituacao(clienteAtualizado.getSituacao());

        logger.info("Editando cliente com ID {}. Dados recebidos: {}",id, clienteAtualizado);
        return clienteRepository.save(clienteExistente);
    }

    @Transactional(readOnly = false)
    public void desativarCliente(Long id){
        Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));

        clienteExistente.setAtivo(false);
        clienteRepository.save(clienteExistente);
        logger.info("Desativando cliente com ID: {}", id);
    }

    public Cliente buscarClientePorId(Long id){
        logger.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(CLIENTE_NAO_ENCONTRADO, id)));
    }


   public Page<Cliente> buscarTodosClientesPaginados(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        logger.info("Buscando clientes com paginação: page={}, size={}", page, size);
        return clienteRepository.findAll(pageable);
   }

   public List<Cliente>  buscarClientesPorNome(String nome){
        logger.info("Buscando clientes por nome: {}", nome);
        return clienteRepository.findByNome(nome);
   }

}
