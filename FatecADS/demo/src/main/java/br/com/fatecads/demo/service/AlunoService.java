package br.com.fatecads.demo.service;

import br.com.fatecads.demo.entity.Aluno;
import br.com.fatecads.demo.repository.ALunoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final ALunoRepository alunoRepository;

    public AlunoService(ALunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}
