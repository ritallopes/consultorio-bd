package com.ritallopes.service;

import java.util.ArrayList;

import com.ritallopes.dao.PacienteDAO;
import com.ritallopes.entities.Paciente;

public class AtendenteService {

	public void mostrarTodosPacientes() {
		
		ArrayList<Paciente> pcs = PacienteDAO.getInstance().listPacientes();
		
		int index = 0;
		for (Paciente p: pcs) {
			index++;
			System.out.println(index + " - "+ p.toString());
		}
		
		
	}

}
