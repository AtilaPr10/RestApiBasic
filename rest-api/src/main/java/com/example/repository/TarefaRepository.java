package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Tarefa;

 public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
