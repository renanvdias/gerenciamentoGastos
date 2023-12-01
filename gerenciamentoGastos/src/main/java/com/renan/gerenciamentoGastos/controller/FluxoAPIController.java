package com.renan.gerenciamentoGastos.controller;

import com.renan.gerenciamentoGastos.model.Movimentacoes;
import com.renan.gerenciamentoGastos.service.MovimentacoesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentacoes")
public class FluxoAPIController {
    
    @Autowired
    MovimentacoesService movimentacoesService;
    
    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Movimentacoes> addMovimentacoes(@RequestBody Movimentacoes mov) {
        var novaMov = movimentacoesService.criar(mov);
        return new ResponseEntity<>(novaMov, HttpStatus.CREATED);
    }
    
    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Movimentacoes> movs = movimentacoesService.listarTodos();
        return new ResponseEntity<>(movs, HttpStatus.OK);
    }
    
    //buscar(R)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Movimentacoes> pesquisar(@PathVariable Integer id) {
        Movimentacoes movEncontrado = movimentacoesService.buscarPorId(id);
        return new ResponseEntity<>(movEncontrado, HttpStatus.OK);
    }
    
    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Movimentacoes> editMov(@PathVariable Integer id, @RequestBody Movimentacoes mov) {
        var editarMov = movimentacoesService.atualizar(id, mov);
        return new ResponseEntity<>(editarMov, HttpStatus.OK);
    }
    
    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        movimentacoesService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
