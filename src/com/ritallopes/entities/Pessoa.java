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

	protected String email;

	protected String cep;
	
	public Pessoa(String nome, String cpf, String telefone, String email, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
	}
	
	public String toString() {
		return "CPF:"+this.cpf+", Nome: "+this.nome+", Telefone:"+this.telefone+", Email:"+this.email+"CEP:"+this.cep+", ";
	}

}
