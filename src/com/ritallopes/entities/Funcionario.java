/**
 * 
 */
package com.ritallopes.entities;

import lombok.*;

/**
 * @author Rita Lopes
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa{
	private String dataContratacao;
	public Funcionario(String nome, String  cpf, String  telefone, String email, String cep, String  dataContratacao) {
		super(nome, cpf, telefone, email, cep);
		this.dataContratacao = dataContratacao;
	}
	public String toString() {
		return super.toString().concat(" Data Cadastro: "+this.dataContratacao+",");
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
}
