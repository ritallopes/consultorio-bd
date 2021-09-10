package com.ritallopes.dao;
import java.util.ArrayList;
import com.ritallopes.entities.Paciente;
/**
 * @author Rita
 *
 */
public interface IPaciente {
	public void update(Paciente paciente);
	 public void insert(Paciente paciente);
	 public Paciente search(String cpf);
	 public void delete(Paciente paciente);
	 public ArrayList<Paciente> listPacientes();
}
