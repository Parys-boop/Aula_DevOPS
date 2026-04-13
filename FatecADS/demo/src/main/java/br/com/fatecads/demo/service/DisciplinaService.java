package br.com.fatecads.demo.service;

import br.com.fatecads.demo.entity.Disciplina;
import br.com.fatecads.demo.repository.DisciplinaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public void deleteById(Integer id) {
        disciplinaRepository.deleteById(id);
    }

    public Disciplina findById(Integer id) {
        return disciplinaRepository.findById(id).orElse(null);
    }
}
