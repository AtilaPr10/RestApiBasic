package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Tarefa;

 public interface TarefaRepository extends JpaRepository<Tarefa, Integer>,CrudRepository<Tarefa, Integer>,PagingAndSortingRepository<Tarefa, Integer>{

	 //Metodo padrao springdata 
	 List<Tarefa> findByDescricao(String descricao);
	 
	 //Metodo utiliziando query personalizada
	 @Query("select t from Tarefa t where (t.descricao) like %:descricao%")
	 List<Tarefa> pesquisaPorParteDoNome(@Param("descricao") String descricao);
	 
	 
	 
	 
}
