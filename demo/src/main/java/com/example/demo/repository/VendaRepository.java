package com.example.demo.repository;

import com.example.demo.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDescricaoProdutoContainingIgnoreCase(String descricaoProduto);

    List<Venda> findByValorTotalGreaterThan(Double valor);

    @Query("SELECT v FROM Venda v WHERE v.dataVenda BETWEEN :inicio AND :fim")
    List<Venda> findVendasEntreDatas(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    List<Venda> findByProdutoId(Long produtoId);
}

