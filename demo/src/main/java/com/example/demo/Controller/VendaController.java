package com.example.demo.Controller;

import com.example.demo.model.Venda;
import com.example.demo.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<Venda> salvarVenda(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.salvarVenda(venda));
    }

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<List<Venda>> buscarPorCliente(@PathVariable String nome) {
        return ResponseEntity.ok(vendaService.buscarVendasPorNomeCliente(nome));
    }

    @GetMapping("/valor-maior-que/{valor}")
    public ResponseEntity<List<Venda>> buscarPorValorMaiorQue(@PathVariable Double valor) {
        return ResponseEntity.ok(vendaService.buscarVendasPorValorMaiorQue(valor));
    }

    @GetMapping("/entre/{inicio}/{fim}")
    public ResponseEntity<List<Venda>> buscarEntreDatas(@PathVariable String inicio, @PathVariable String fim) {
        LocalDateTime dataInicio = LocalDateTime.parse(inicio);
        LocalDateTime dataFim = LocalDateTime.parse(fim);
        return ResponseEntity.ok(vendaService.buscarVendasEntreDatas(dataInicio, dataFim));
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<Venda>> buscarPorProdutoId(@PathVariable Long produtoId) {
        return ResponseEntity.ok(vendaService.buscarVendasPorProdutoId(produtoId));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarTodas() {
        return ResponseEntity.ok(vendaService.listarTodas());
    }
}

