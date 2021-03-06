package com.ritallopes.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ritallopes.dao.AtendenteDAO;
import com.ritallopes.dao.MedicoDAO;
import com.ritallopes.dao.PacienteDAO;
import com.ritallopes.entities.Atendente;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

public class AtendenteService {
	Scanner in = new Scanner(System.in);

	public void mostrarTodosPacientes() {
		ArrayList<Paciente> pcs = PacienteDAO.getInstance().listPacientes();
		int index = 0;
		for (Paciente p: pcs) {
			index++;
			System.out.println(index + " - "+ p.toString());
		}	
		
	}

	public void cadastrarPaciente(){
		System.out.println("Nome do paciente: ");
		String nome = in.nextLine();
		System.out.println("CPF do paciente: ");
		String cpf = in.nextLine();
		System.out.println("Telefone do paciente: ");
		String telefone = in.nextLine();
		System.out.println("Email do paciente: ");
		String email = in.nextLine();
		System.out.println("CEP do paciente: ");
		String cep = in.nextLine();
		System.out.println("Convenio do paciente: ");
		String convenio = in.nextLine();
		System.out.println("Data de cadastro do paciente: ");
		String dataCadastro = in.nextLine();

		Paciente paciente = new Paciente(cpf, nome,telefone, email, cep, convenio, dataCadastro);

		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.insert(paciente);
	}

	public void removerPaciente(){
		System.out.println("Informe o CPF do paciente: ");
		String cpf = in.nextLine();

		PacienteDAO pacienteDAO = new PacienteDAO();
		Paciente paciente = pacienteDAO.search(cpf);
		pacienteDAO.delete(paciente);
	}

	public void atualizarPaciente(){
		System.out.println("Novo nome do paciente: ");
		String nome = in.nextLine();
		System.out.println("Novo CPF do paciente: ");
		String cpf = in.nextLine();
		System.out.println("Novo Telefone do paciente: ");
		String telefone = in.nextLine();
		System.out.println("Novo Email do paciente: ");
		String email = in.nextLine();
		System.out.println("Novo CEP do paciente: ");
		String cep = in.nextLine();
		System.out.println("Novo Convenio do paciente: ");
		String convenio = in.nextLine();
		System.out.println("Nova Data de cadastro do paciente: ");
		String dataCadastro = in.nextLine();

		Paciente paciente = new Paciente(cpf, nome,telefone, email, cep, convenio, dataCadastro);

		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.update(paciente);
	}

	
	
	public void agendarConsulta(){
		
		if(escolherAtendente() == null) {
			System.out.println("CPF n?o encontrado, tente novamente!");
			return;
		}
		
		Paciente p = escolherPaciente();
		Medico m = escolherMedico();
		

	}
	public Atendente escolherAtendente() {
		System.out.println("Digite seu CPF: ");
		String cpf = in.nextLine();
		Atendente a = AtendenteDAO.getInstance().search(cpf);
		return a;		
	}
	
	public Paciente escolherPaciente() {
		ArrayList<Paciente> pcs = PacienteDAO.getInstance().listPacientes();
		int index = 0;
		System.out.println("Escolha o paciente: ");
		for (Paciente p: pcs) {
			index++;
			System.out.println(index + " - "+ p.toString());
		}	
		int i = in.nextInt();
		return pcs.get(i-1);	
	}
	public Medico escolherMedico() {
		ArrayList<Medico> ms = MedicoDAO.getInstance().listMedicos();
		int index = 0;
		System.out.println("Escolha o medico: ");
		for (Medico m: ms) {
			index++;
			System.out.println(index + " - "+ m.toString());
		}	
		int i = in.nextInt();
		return ms.get(i-1);
	}


	public void atualizarConsulta(){

	}

	public void desmarcarConsulta(){

	}
}
