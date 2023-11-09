package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TarefaDto;
import com.example.demo.model.Tarefa;
import com.example.demo.service.TarefaService;


@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
	
	@Autowired
    private TarefaService tarefa_service;
	
	@Autowired
	private ModelMapper model_mapper;
	

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		
	    return tarefa_service.salvar(tarefa);
		
		
	}
	
	@GetMapping("/{id}")
	public Optional<Tarefa> listarporId(@PathVariable Integer id) {
		
		return tarefa_service.ListaTarefaPorId(id);
		
	}
	
	@GetMapping
	public List<TarefaDto> listarTarefas(){
		
		return tarefa_service.ListaTodasasTarefas();
		
	}
	

	
	
}
