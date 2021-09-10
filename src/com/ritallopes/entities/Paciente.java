/**
 * 
 */
package com.ritallopes.entities;

import lombok.*;

/**
 * @author Rita Lopes
 *
 */
@Data
public class Paciente extends Pessoa {
	private String convenio;
	private String dataCadastro;
	public Paciente() {
		super();
	}
	public Paciente(String cpf, String nome, String telefone, String email, String cep, String convenio, String dataCadastro) {
		super(nome, cpf, telefone, email, cep);
		this.convenio = convenio;
		this.dataCadastro = dataCadastro;
	}


	public String toString() {
		return super.toString().concat(" Convenio: "+this.convenio+", data de Cadastro: "+this.dataCadastro);
	}
	public void setConvenio(String string) {
		this.convenio = string;		
	}
	public void setDataCadastro(String string) {
		this.dataCadastro = string;		
	}
	
	public String getConvenio() {
		return this.convenio;
	}
	public String getDataCadastro() {
		return this.dataCadastro;
	}
	
	
}
