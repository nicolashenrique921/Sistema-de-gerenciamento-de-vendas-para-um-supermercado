package com.example.demo.service;


import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> buscarVendasPorNomeCliente(String nome) {
        return vendaRepository.findByDescricaoProdutoContainingIgnoreCase(nome);
    }

    public List<Venda> buscarVendasPorValorMaiorQue(Double valor) {
        return vendaRepository.findByValorTotalGreaterThan(valor);
    }

    public List<Venda> buscarVendasEntreDatas(LocalDateTime inicio, LocalDateTime fim) {
        return vendaRepository.findVendasEntreDatas(inicio, fim);
    }

    public List<Venda> buscarVendasPorProdutoId(Long produtoId) {
        return vendaRepository.findByProdutoId(produtoId);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }
}

