package com.renan.gerenciamentoGastos.controller;

import com.renan.gerenciamentoGastos.model.Movimentacoes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FluxoController {
    
    @GetMapping("/")
    public String exibirHome(Model model) {
        model.addAttribute("movimentacoes", new Movimentacoes());
        return "fluxo";
    }
    
}
