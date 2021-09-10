
import com.ritallopes.dao.PacienteDAO;
import com.ritallopes.displayFunctions.Display;
import com.ritallopes.entities.Paciente;
import com.ritallopes.service.AtendenteService;
import com.ritallopes.service.MedicoService;
import com.ritallopes.service.PacienteService;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int OPTION_PATIENT = 1;
		final int OPTION_ATTENDANT = 2;
		final int OPTION_MEDIC = 3;
		final int CANCEL = 0;
		
		AtendenteService as = new AtendenteService();
		PacienteService ps = new PacienteService();
		MedicoService ms = new MedicoService();

		Scanner in = new Scanner(System.in);
		Display display = new Display();
		int option = -1;
		int option_aux = -1;

		while(option != CANCEL){
			display.showIdentificationMenu();
			option = in.nextInt();

			if(option == OPTION_PATIENT){
				display.showPatientMenu();
				option_aux = in.nextInt();

				if(option_aux == 1){
					ps.mostrarConsultas();
				} else if(option_aux == 1){
					//TODO solicitar a marcacao de uma consulta
				} else if(option_aux == 3){
					//TODO remarcar a consulta
				} else if(option_aux == 4){
					//TODO desmarcar consulta
				} else if(option_aux == 5) {
					//TODO ver laudo do paciente
				} else if(option_aux == 6){
					//TODO efetuar pagamento da consulta
				} else {
					System.out.println("Voltando...");
				}

			} else if(option == OPTION_ATTENDANT){
				display.showAttendantMenu();
				option_aux = in.nextInt();

				if(option_aux == 1){
					as.cadastrarPaciente();
				} else if(option_aux == 2){
					as.removerPaciente();
				} else if(option_aux == 3){
					as.mostrarTodosPacientes();
				} else if(option_aux == 4){
					as.atualizarPaciente();
				} else if(option_aux == 5){
					//TODO agendar consulta
				} else if(option_aux == 6){
					//TODO atualizar consulta
				} else if(option_aux == 7){
					//TODO desmarcar consulta
				} else {
					System.out.println("Voltando...");
				}

			} else if(option == OPTION_MEDIC){
				display.showMedicMenu();
				option_aux = in.nextInt();

				if(option_aux == 1){
					//TODO adicionar laudo
				} else if(option_aux == 2){
					//TODO ver laudo
				} else if(option_aux == 3){
					//TODO remover laudo
				} else {
					System.out.println("Voltando...");
				}
			}
		}

	}
}
