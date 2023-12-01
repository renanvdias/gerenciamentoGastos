package com.renan.gerenciamentoGastos.repository;

import com.renan.gerenciamentoGastos.model.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Integer>{
    
}
