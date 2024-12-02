package com.oticasertaneja.otica_sertaneja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.oticasertaneja.otica_sertaneja.Entity.Cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNome(String nome);

    Page<Cliente> findByGrupoId(Pageable pageable, Long id);

    Page<Cliente> findByAtivoTrue(Pageable pageable);

    boolean existsByCpf(String cpf);
}
