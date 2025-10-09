package com.byteshop.ByteShop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produtos") // Isso conecta a classe com a tabela "produtos" no banco de dados
@Data 
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id do produto (Long)

    @Column(nullable = false)
    private String nome; // Nome do produto (String)

    @Column(nullable = false)
    private BigDecimal preco; // Preço do produto (BigDecimal)

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque; // Quantidade em estoque (int)

    private boolean disponivel; // Disponibilidade do produto (boolean)

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro; // Data de cadastro do produto (LocalDate)

}