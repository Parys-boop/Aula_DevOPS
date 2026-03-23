package br.com.fatecads.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fatecads.demo.entity.Aluno;

public interface ALunoRepository extends JpaRepository<Aluno, Integer>{

    
}