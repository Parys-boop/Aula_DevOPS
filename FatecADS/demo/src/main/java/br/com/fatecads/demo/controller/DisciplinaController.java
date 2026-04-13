package br.com.fatecads.demo.controller;

import br.com.fatecads.demo.entity.Disciplina;
import br.com.fatecads.demo.service.DisciplinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina) {
        disciplinaService.save(disciplina);
        return "redirect:/disciplina/listar";
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("disciplinas", disciplinaService.findAll());
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/index";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/formularioDisciplina";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Disciplina disciplina = disciplinaService.findById(id);
        model.addAttribute("disciplina", disciplina);
        return "disciplina/formularioDisciplina";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        disciplinaService.deleteById(id);
        return "redirect:/disciplina/listar";
    }
}
