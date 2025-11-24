package com.byteshop.ByteShop.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Uma categoria tem MUITOS produtos
    // 'mappedBy' indica que o dono da relação é o campo 'categoria' lá na classe Produto
    @OneToMany(mappedBy = "categoria") 
    private List<Produto> produtos;
}