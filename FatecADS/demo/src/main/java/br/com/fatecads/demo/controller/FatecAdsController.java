package br.com.fatecads.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FatecAdsController {

    @GetMapping("/")
    public String index() {
        return "redirect:/aluno/listar";
    }
}
