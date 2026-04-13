package br.com.fatecads.demo.service;

import br.com.fatecads.demo.entity.Professor;
import br.com.fatecads.demo.repository.ProfessorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }

    public Professor findById(Integer id) {
        return professorRepository.findById(id).orElse(null);
    }
}
