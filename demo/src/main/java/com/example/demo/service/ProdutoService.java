package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutosPorPrecoMaiorQue(Double preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public List<Produto> buscarProdutosPorSetor(String setor) {
        return produtoRepository.findBySetorIgnoreCase(setor);
    }

    public List<Produto> buscarProdutosPorValidadeDepoisDe(LocalDate data) {
        return produtoRepository.findProdutosValidadeMaiorQue(data);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
}

