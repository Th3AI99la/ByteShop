package com.byteshop.ByteShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteshop.ByteShop.model.Produto;
import com.byteshop.ByteShop.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos") // Essa e Rota base para todos os endpoints de produtos
@CrossOrigin(origins = "http://localhost:4200") // Permite requisições do Angular rodando na porta 4200
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;  

    // LISTAR TODOS (GET /api/produtos)
    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }

    // CONSULTAR POR ID (GET /api/produtos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(produto -> ResponseEntity.ok(produto)) // Se encontrar, retorna 200 OK com o produto
                .orElse(ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    // INCLUIR (POST /api/produtos)
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        // Retorna 201 Created com o produto criado
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    // ALTERAR (PUT /api/produtos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        try {
            Produto produtoAtualizado = produtoService.atualizar(id, produto);
            return ResponseEntity.ok(produtoAtualizado); // Retorna 200 OK com o produto atualizado
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o produto não existir
        }
    }

    // EXCLUIR (DELETE /api/produtos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content, indicando sucesso na exclusão
    }
}