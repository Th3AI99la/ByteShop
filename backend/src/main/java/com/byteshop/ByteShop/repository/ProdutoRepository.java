package com.byteshop.ByteShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteshop.ByteShop.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui podemos definir métodos de consulta personalizados, se necessário.
}