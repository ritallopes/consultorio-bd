package com.ritallopes.entities;

import lombok.*;
import lombok.experimental.NonFinal;

@Getter
@Setter
@NonFinal
public class Pessoa {
	
	protected String nome;
	
	protected String cpf;
	
	protected String telefone;

	protected String email;

	protected String cep;
	public Pessoa() {};

	public Pessoa(String nome, String cpf, String telefone, String email, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
	}
	
	public String toString() {
		return "CPF:"+this.cpf+", Nome: "+this.nome+" Email:"+this.email+"CEP:"+this.cep+", ";
	}

	public String getCpf() { return this.cpf;}
	public void setCpf(String cpf) { this.cpf = cpf;}
	public String getNome() { return this.nome;}
	public void setNome(String nome) { this.nome = nome;}
	public String getTelefone() { return this.telefone;}
	public void setTelefone(String telefone) { this.telefone = telefone;}
	public String getEmail() { return this.email;}
	public void setEmail(String email) { this.email = email;}
	public String getCep() { return this.cep;}
	public void setCep(String cep) { this.cep = cep;}
	
}
