package br.com.fatecads.demo.repository;

import br.com.fatecads.demo.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
