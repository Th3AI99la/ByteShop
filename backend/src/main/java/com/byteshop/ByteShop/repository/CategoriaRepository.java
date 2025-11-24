package com.byteshop.ByteShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteshop.ByteShop.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}