package com.byteshop.ByteShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteshop.ByteShop.model.Categoria;
import com.byteshop.ByteShop.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }
}