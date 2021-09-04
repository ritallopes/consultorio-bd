package com.ritallopes.entities;

import lombok.*;
import lombok.experimental.NonFinal;

@Getter
@Setter
@NonFinal
@NoArgsConstructor
public class Pessoa {
	
	protected String nome;
	
	protected String cpf;
	
	protected String telefone;
	
	public Pessoa(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	public String toString() {
		return "CPF:"+this.cpf+", Nome: "+this.nome+", Telefone:"+this.telefone+" ,";
	}

}
