package br.com.fatecads.demo.controller;

import br.com.fatecads.demo.entity.Professor;
import br.com.fatecads.demo.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professor/listar";
    }

    @GetMapping({"", "/", "/listar"})
    public String listar(Model model) {
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("professor", new Professor());
        return "professor/index";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/formularioProfessor";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "professor/formularioProfessor";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        professorService.deleteById(id);
        return "redirect:/professor/listar";
    }
}
