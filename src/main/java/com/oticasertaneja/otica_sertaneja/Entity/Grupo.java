package com.oticasertaneja.otica_sertaneja.Entity;

import java.util.List;

import com.oticasertaneja.otica_sertaneja.Entity.Cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "grupo")
@Data
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "grupo")
    private List<Cliente> clientes;
}
