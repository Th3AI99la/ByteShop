package com.byteshop.ByteShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteshop.ByteShop.model.Produto;
import com.byteshop.ByteShop.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    // Operação LISTAR
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Operação CONSULTAR
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Operação INCLUIR
    public Produto salvar(Produto produto) {
        // --- CORREÇÃO AQUI ---
        // Antes de salvar, precisamos amarrar o Detalhe ao Produto.
        if (produto.getDetalhe() != null) {
            produto.getDetalhe().setProduto(produto); // "Detalhe, este é seu pai"
        }
        
        // Validamos se a categoria veio nula (opcional, mas bom para evitar erros)
        if (produto.getCategoria() != null && produto.getCategoria().getId() == null) {
             produto.setCategoria(null); 
        }

        return produtoRepository.save(produto);
    }

    // Operação EXCLUIR
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    // Operação ALTERAR
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    // Atualiza dados básicos
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    produtoExistente.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
                    produtoExistente.setDisponivel(produtoAtualizado.isDisponivel());
                    produtoExistente.setDataCadastro(produtoAtualizado.getDataCadastro());
                    
                    // --- ATUALIZAÇÃO DA CATEGORIA ---
                    produtoExistente.setCategoria(produtoAtualizado.getCategoria());

                    // --- ATUALIZAÇÃO DO DETALHE ---
                    if (produtoAtualizado.getDetalhe() != null) {
                        if (produtoExistente.getDetalhe() == null) {
                            // Se não tinha detalhe antes, cria um novo
                            produtoExistente.setDetalhe(produtoAtualizado.getDetalhe());
                            produtoExistente.getDetalhe().setProduto(produtoExistente);
                        } else {
                            // Se já tinha, apenas atualiza os campos (para manter o mesmo ID)
                            produtoExistente.getDetalhe().setEspecificacaoTecnica(
                                produtoAtualizado.getDetalhe().getEspecificacaoTecnica()
                            );
                            produtoExistente.getDetalhe().setGarantiaMeses(
                                produtoAtualizado.getDetalhe().getGarantiaMeses()
                            );
                        }
                    } else {
                        // Se o detalhe foi removido, zera a referência
                        
                    }

                    return produtoRepository.save(produtoExistente);
                }).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }
}