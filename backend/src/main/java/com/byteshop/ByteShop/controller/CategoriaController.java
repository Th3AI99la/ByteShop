package com.byteshop.ByteShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteshop.ByteShop.model.Categoria;
import com.byteshop.ByteShop.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:4200") // Permite o Angular acessar
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }
}