package br.com.fatecads.demo.repository;

import br.com.fatecads.demo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
