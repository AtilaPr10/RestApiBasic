package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefa_repository;
	

	public Tarefa salvar (Tarefa tarefa) {
		
		return tarefa_repository.save(tarefa);
		
		
	}
	
	
	public List<Tarefa> ListaTodasasTarefas(){
		
		return tarefa_repository.findAll();
		
	}
	
	
	public Optional<Tarefa> ListaTarefaPorId(Integer id) {
		
		return tarefa_repository.findById(id);
	
	}
	
	
}
