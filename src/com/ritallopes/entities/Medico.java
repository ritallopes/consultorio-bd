/**
 * 
 */
package com.ritallopes.entities;

import java.util.Date;
import java.util.List;

import com.ritallopes.entities.Consulta;

/**
 * @author Rita Lopes
 *
 */
import lombok.*;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends Funcionario{
	@NonNull
	private String crm;
	@NonNull
	private String especialidade;
	
	private List<Consulta> consultas;
	
	public Medico(String cpf, String nome, String telefone, String email, String cep, String dataContratacao, String crm, String especialidade, List<Consulta> consultas) {
		super(nome, cpf, telefone, email, cep, dataContratacao);
		this.crm = crm;
		this.especialidade = especialidade;
		this.consultas = consultas;
	}
	public Medico() {
		
	}
	public String toString() {
		return super.toString().concat(" CRM: "+this.crm+", Especialidade: "+this.especialidade);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
