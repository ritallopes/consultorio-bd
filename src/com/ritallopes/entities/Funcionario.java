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
	public Funcionario(String nome, String  cpf, String  telefone, String  dataContratacao) {
		super(nome, cpf, telefone);	
		this.dataContratacao = dataContratacao;
	}
	public String toString() {
		return super.toString().concat(" Data Cadastro: "+this.dataContratacao+",");
	}
}
