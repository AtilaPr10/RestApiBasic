package com.example.demo.exception;

import java.util.Map;

public class ErrorDto {
	
	
	private Map<String,String> erros;

	public ErrorDto(Map<String, String> erros) {
		
		this.erros = erros;
	}

	public Map<String, String> getErros() {
		return erros;
	}

	public void setErros(Map<String, String> erros) {
		this.erros = erros;
	}
	
	
	
	
	

}
