package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
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
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
	
	@Autowired
    private TarefaService tarefa_service;
	
	
	

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tarefa salvarTarefa(@RequestBody @Valid Tarefa tarefa) {
		
	    return tarefa_service.salvar(tarefa);
		
		
	}
	
	
	@RequestMapping(value = "/nome/{nome}")
	public List<TarefaDto> listaPorNome(@PathVariable String nome){
		
		return tarefa_service.buscarTarefaPorNome(nome);
		
	}
	
	
	@RequestMapping(value = "/likenome/{param}")
	public List<TarefaDto> listaPorParteNome(@PathVariable String param){
		
		return tarefa_service.buscarTarefaPorParteDoNome(param.toLowerCase());
		
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
