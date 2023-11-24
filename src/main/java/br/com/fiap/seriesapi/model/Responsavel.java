package br.com.fiap.seriesapi.model;

public record Responsavel(
	
	Long id,
	String nome,
	Long cpf,
	Integer telefone,
	Integer telefone2,
	String email,
	String senha
		
){
	
}
