package com.oticasertaneja.otica_sertaneja.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.oticasertaneja.otica_sertaneja.Entity.Cobrador.Cobrador;

public interface CobradorRepository extends JpaRepository<Cobrador, Long> {
    
}
