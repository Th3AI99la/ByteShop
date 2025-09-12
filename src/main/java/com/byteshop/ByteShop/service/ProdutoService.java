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

    // Operação LISTAR: Retorna todos os produtos.
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Operação CONSULTAR: Busca um produto pelo seu ID.
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Operação INCLUIR: Salva um novo produto no banco.
    public Produto salvar(Produto produto) {
        // A ideia futura é adicionar validações aqui, como verificar se o nome do produto já existe :)
        return produtoRepository.save(produto);
    }

    // Operação EXCLUIR: Deleta um produto pelo seu ID.
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    // Operação ALTERAR: Atualiza um produto existente.
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        // Verifica se o produto com o ID fornecido existe, se sim, atualiza, se não, lança um erro.
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    // Se encontramos, atualizamos os dados com as informações recebidas.
                    produtoExistente.setNome(produtoAtualizado.getNome());
                    produtoExistente.setPreco(produtoAtualizado.getPreco());
                    produtoExistente.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
                    produtoExistente.setDisponivel(produtoAtualizado.isDisponivel());
                    produtoExistente.setDataCadastro(produtoAtualizado.getDataCadastro());
                    // Salvamos o produto com as alterações.
                    return produtoRepository.save(produtoExistente);
                }).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id)); // Lançamos um erro se o produto não existe.
    }
}