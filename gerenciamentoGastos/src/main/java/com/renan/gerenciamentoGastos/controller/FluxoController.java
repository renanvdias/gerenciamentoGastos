package com.renan.gerenciamentoGastos.controller;

import com.renan.gerenciamentoGastos.model.Movimentacoes;
import com.renan.gerenciamentoGastos.service.MovimentacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FluxoController {
    
    @Autowired 
    MovimentacoesService movimentacoesService;
    
    @GetMapping("/")
    public String exibirHome(Model model) {
        model.addAttribute("movimentacoes", new Movimentacoes());
        return "fluxo";
    }
    
    @GetMapping("/fluxo")
    public String exibirFluxo(Model model) {
        model.addAttribute("movimentacoes", new Movimentacoes());
        return "fluxo";
    }
    
    @GetMapping("/lista") //eh definido a URL que sera chamada
    public String listaForm(Model model){
        model.addAttribute("lista", movimentacoesService.listarTodos());
        return "fluxo"; //sera apontado o arquivo HTML que sera chamado
    }
    
    @PostMapping("/cadastrarMovimentacao")
    public String cadastrarMovimentacao(@ModelAttribute Movimentacoes mov, Model model) {
        
        if (mov.getId()!=null) {
           movimentacoesService.atualizar(mov.getId(), mov);
        } else {
            movimentacoesService.criar(mov);
        }
        return "redirect:/fluxo";
    }
    
    @GetMapping("/excluir")
    public String excluirFilme(Model model, @RequestParam String id) {
        Integer idMovimentacao = Integer.parseInt(id);
        movimentacoesService.excluir(idMovimentacao);
        return "redirect:/fluxo";
    }
    
    @GetMapping("/alterar")
    public String alterarFilme(Model model, @RequestParam String id) {
        Integer idMov = Integer.parseInt(id);
        Movimentacoes movEncontrado = movimentacoesService.buscarPorId(idMov);
        model.addAttribute("movimentacoes", movEncontrado);
        return "alterar";
    }
}
