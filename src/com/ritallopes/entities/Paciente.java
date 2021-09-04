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
@NoArgsConstructor
public class Paciente extends Pessoa {
	private String convenio;
	private String dataCadastro;
	public Paciente(String cpf, String nome, String telefone, String convenio, String dataCadastro) {
		super(nome, cpf, telefone);
		this.convenio = convenio;
		this.dataCadastro = dataCadastro;
	}
	public String toString() {
		return super.toString().concat(" Convenio: "+this.convenio+", data de Cadastro: "+this.dataCadastro);
	}
}
