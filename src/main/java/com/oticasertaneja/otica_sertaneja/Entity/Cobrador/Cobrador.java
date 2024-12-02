package com.oticasertaneja.otica_sertaneja.Entity.Cobrador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cobrador")
@Data
@NoArgsConstructor
public class Cobrador extends AbstractPersistable<Long> {
    
    @NotNull(message = "O nome não pode ser nulo")
    @Size(max = 50, message = "O Nome deve ter no maximo 50 Caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 50, message = "A Cidade de Residência deve ter no máximo 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ú ]*$",message = "A Cidade de Residência deve conter apenas letras e espaços")
    @Column(name = "cidade_residencia")
    private String cidadeResidencia;

    @NotNull(message = "A Cidade de Coleta não pode ser nula")
    @Size(max = 50, message = "A Cidade de Coleta deve ter no máximo 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ú ]*$",message = "A Cidade de Coleta deve conter apenas letras e espaços")
    @Column(name = "cidade_coleta", nullable = false)
    private String cidadeColeta;

    @Min(value = 0, message = "A receita deve ser positiva")
    @Column(name = "receita")
    private BigDecimal receita = BigDecimal.ZERO;

    @Size(max = 30, message = "O veículo deve ter no máximo 30 caracteres")
    @Pattern(regexp = "^[a-zA-ZÀ-ú ]*$",message = "A Cidade de Coleta deve conter apenas letras e espaços")
    @Column(name = "veiculo_utilizado")
    private String veiculoUtilizado;

    @Min(value = 0, message = "A quilometragem deve ser positiva")
    @Column(name = "km")
    private BigDecimal km = BigDecimal.ZERO;

    @Min(value = 0, message =  "As despesas devem ser positivas")
    @Column(name = "despesas")
    private BigDecimal despesas = BigDecimal.ZERO;

    @Past(message = "A data de nascimento deve estar no passado")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
