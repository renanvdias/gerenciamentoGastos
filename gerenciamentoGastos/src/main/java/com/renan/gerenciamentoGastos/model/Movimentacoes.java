package com.renan.gerenciamentoGastos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Movimentacoes")
public class Movimentacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    private double valor;
    private String data;
    @Lob
    private String descricao;
    private String tipo;
}
