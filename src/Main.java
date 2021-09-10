import java.util.ArrayList;

import com.ritallopes.dao.IPaciente;
import com.ritallopes.dao.PacienteDAO;
import com.ritallopes.entities.Paciente;


public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Helloo");
		IPaciente pacienteDAO = new PacienteDAO();
		
		ArrayList<Paciente> listemployee = pacienteDAO.listPacientes();
		for (Paciente ep : listemployee) {
			System.out.println(ep.getCpf());
		}
	}
}
