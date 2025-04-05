package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
    List<Produto> findByPrecoGreaterThan(Double preco);

   
    List<Produto> findBySetorIgnoreCase(String setor);

    
    @Query("SELECT p FROM Produto p WHERE p.validade > :data")
    List<Produto> findProdutosValidadeMaiorQue(@Param("data") LocalDate data);
}
