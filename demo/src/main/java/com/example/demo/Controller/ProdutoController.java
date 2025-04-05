package com.example.demo.Controller;


import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Cadastrar um novo produto
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @GetMapping("/preco-maior-que/{preco}")
    public ResponseEntity<List<Produto>> buscarPorPrecoMaiorQue(@PathVariable Double preco) {
        return ResponseEntity.ok(produtoService.buscarProdutosPorPrecoMaiorQue(preco));
    }

    @GetMapping("/setor/{setor}")
    public ResponseEntity<List<Produto>> buscarPorSetor(@PathVariable String setor) {
        return ResponseEntity.ok(produtoService.buscarProdutosPorSetor(setor));
    }

    @GetMapping("/validade-depois-de/{data}")
    public ResponseEntity<List<Produto>> buscarPorValidadeDepoisDe(@PathVariable String data) {
        LocalDate dataFormatada = LocalDate.parse(data);
        return ResponseEntity.ok(produtoService.buscarProdutosPorValidadeDepoisDe(dataFormatada));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
}

