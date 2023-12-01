package com.renan.gerenciamentoGastos.service;

import com.renan.gerenciamentoGastos.model.Movimentacoes;
import com.renan.gerenciamentoGastos.repository.MovimentacoesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacoesService {

    @Autowired
    MovimentacoesRepository movimentacoesRepository;

    public Movimentacoes criar(Movimentacoes mov) {
        mov.setId(null);
        movimentacoesRepository.save(mov);
        return mov;
    }
    
       public List<Movimentacoes> listarTodos() {
        return movimentacoesRepository.findAll();
    }

    public Movimentacoes buscarPorId(Integer id) {
        return movimentacoesRepository.findById(id).orElseThrow();
    }

    public void excluir(Integer id) {
        Movimentacoes movEncontrado = buscarPorId(id); //valida se existe id informado
        movimentacoesRepository.deleteById(movEncontrado.getId());
    }

    public Movimentacoes atualizar(Integer id, Movimentacoes movEnviado) {
        Movimentacoes movEncontrado = buscarPorId(id);
        movEncontrado.setValor(movEnviado.getValor());
        movEncontrado.setData(movEnviado.getData());
        movEncontrado.setDescricao(movEnviado.getDescricao());
        movEncontrado.setTipo(movEnviado.getTipo());
        movimentacoesRepository.save(movEncontrado);
        return movEncontrado;
    }
}
