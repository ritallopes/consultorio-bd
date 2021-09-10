package com.ritallopes.entities;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
	
	@NonNull
	private String id;
	private Paciente paciente;
	private Medico medico;
	private String inicio;
	private String fim;
	private Boolean presenca;
	
	
	public String toString() {
		return "ID: "+this.id+", Inicio: "+this.inicio+", Fim: "+this.fim+" Paciente:\n\t"+this.paciente.toString()+"\n\t Médico:"+this.medico.toString();
	}
	
	
	public String getInicio() {
		return this.inicio;
	}
	
	public String getFim() {
		return this.fim;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	public Medico getMedico() {
		return this.medico;
	}
	
	public boolean getPresenca() {
		return this.presenca;
	}

}
