package com.byteshop.ByteShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DetalheProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especificacaoTecnica;
    private int garantiaMeses;

    @OneToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto;
}