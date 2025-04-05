package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private Long produtoId;
    private String descricaoProduto;
    private Integer quantidade;
    private Double precoProduto;
    private Double valorTotal;
    private LocalDateTime dataVenda;
}