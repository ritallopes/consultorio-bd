/**
 * 
 */
package com.ritallopes.entities;

import java.util.Date;
import java.util.List;

import com.ritallopes.entities.Funcionario;

/**
 * @author Rita Lopes
 *
 */
import lombok.*;
@Data
@Builder
public class Clinica {
	@NonNull
	private String nome;
	private List<Funcionario> funcionarios;

}
