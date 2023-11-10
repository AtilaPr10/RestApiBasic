package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.TarefaDto;
import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;

@Service
public class TarefaService {
	
	
	private final TarefaRepository tarefa_repository;
	
	private final ModelMapper mapper;
	

	 
	
	
	@Autowired
	public TarefaService(TarefaRepository tarefa_repository, ModelMapper mapper) {
		
		this.tarefa_repository = tarefa_repository;
		this.mapper = mapper;
	}


	public Tarefa salvar (Tarefa tarefa) {
		
		return tarefa_repository.save(tarefa);
		
		
	}
	
	
	public List<TarefaDto> buscarTarefaPorNome(String nome) {
		
		return tarefa_repository.findByDescricao(nome).stream()
				.map(tarefa -> mapper.map(tarefa, TarefaDto.class))
				.collect(Collectors.toList());
				
	}
	
	
	public List<TarefaDto> buscarTarefaPorParteDoNome(String partenome){
		
		return tarefa_repository.pesquisaPorParteDoNome(partenome).stream()
				.map(tarefa -> mapper.map(tarefa,TarefaDto.class))
                .collect(Collectors.toList());		
		
	}
	
	
	
	public List<TarefaDto> ListaTodasasTarefas(){
		
		  return tarefa_repository.findAll().stream()
				  .map(tarefa -> mapper.map(tarefa, TarefaDto.class))
				  .collect(Collectors.toList());
	}
	
	
	public Optional<Tarefa> ListaTarefaPorId(Integer id) {
		
		return tarefa_repository.findById(id);
	
	}
	
	
}
