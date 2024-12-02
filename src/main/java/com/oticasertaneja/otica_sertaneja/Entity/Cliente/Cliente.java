package com.oticasertaneja.otica_sertaneja.Entity.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.oticasertaneja.otica_sertaneja.Entity.Grupo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@Data
@NoArgsConstructor

public class Cliente extends AbstractPersistable<Long>{

    //Dado Pessoal
    @NotNull(message = "O nome não pode ser nulo")
    @Size(max = 50, message = "O Nome deve ter no maximo 50 Caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;

    //Dado Pessoal
    @NotNull(message = "O CPF não pode ser nulo")
    @Size(min = 11, max = 11, message =  "O CPF deve ter exatamente 11 digitos")
    @Pattern(regexp ="\\d{11}", message = "O CPF deve conter apenas números")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @NotNull(message = "Tipo do Óculos não pode ser nulo")
    @Column(name = "tipo_oculos", nullable = false)
    private String tipoOculos;

    @Column(name = "data_validade_oculos")
    private LocalDate dataValidadeOculos;

    @Column(name = "data_vencimento_parcela")
    private LocalDate dataVencimentoParcela;

    @Min(value = 0, message = "A quantidade de parcelas não pode ser negativa")
    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas = 0;

    @Min(value = 0, message = "O número de parcelas pagas não pode ser negativo")
    @Column(name = "parcelas_pagas")
    private Integer parcelasPagas = 0;

    //Dado Pessoal
    @Pattern(regexp = "\\d{11}", message = "O contato deve ter 11 digitos incluindo DDD")
    @Column(name = "contato_whatsapp")
    private String contatoWhatsapp;

    //Dado Pessoal
    @Past(message = "A data de nascimento deve estar no passado")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "afiliado")
    private Boolean afiliado = false;

    @NotNull(message = "O CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "O CEP deve conter exatamente 8 números")
    @Column(name = "cep", nullable = false)
    private String cep;

    @NotNull(message = "A Rua não pode ser nula")
    @Column(name = "rua", nullable = false)
    private String rua;

    @Min(value = 0, message = "O número da casa deve ser positivo")
    @Column(name = "numero_casa")
    private Integer numeroCasa;

    @NotNull(message = "O Bairro não pode ser nulo")
    @Column(name = "bairro", nullable = false)
    private String bairro;

    @NotNull(message = "Cidade não pode ser nula")
    @Column(name = "cidade", nullable = false)
    private String cidade;

    @NotNull(message = "O UF não pode ser nulo")
    @Column(name = "uf", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumEstado uf;

    @Column(name = "cliente_desde")
    private LocalDate clienteDesde;

    @Column(name = "inicio_parcelamento")
    private LocalDate inicioParcelamento;


    @Column(name = "situacao")
    @Enumerated(EnumType.STRING)
    private EnumSituacao situacao;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
}
