package br.com.fatecads.demo.controller;

import br.com.fatecads.demo.entity.Aluno;
import br.com.fatecads.demo.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/aluno/listar";
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("aluno", new Aluno());
        return "aluno/index";
    }
}
