package com.byteshop.ByteShop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    private boolean disponivel;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;


    // 1. Relacionamento N:1 com Categoria (Muitos produtos para uma categoria)
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // 2. Relacionamento 1:1 com DetalheProduto
    // CascadeType.ALL: Se deletar o produto, deleta o detalhe junto.
    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private DetalheProduto detalhe;

    // 3. Relacionamento N:N com Fornecedor
    // Cria a tabela intermediária 'produto_fornecedor' automaticamente
    @ManyToMany
    @JoinTable(
        name = "produto_fornecedor",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
    )
    private List<Fornecedor> fornecedores;
}