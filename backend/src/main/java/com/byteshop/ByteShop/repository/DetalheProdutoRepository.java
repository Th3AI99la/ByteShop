package com.byteshop.ByteShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteshop.ByteShop.model.DetalheProduto;

@Repository
public interface DetalheProdutoRepository extends JpaRepository<DetalheProduto, Long> {
}