package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ritallopes.connection.ConnectionFactory;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Paciente;

public class ConsultaDAO {
	private static ConsultaDAO consultaDAO;

	public static ConsultaDAO getInstance() {
		if (consultaDAO == null) {
			consultaDAO = new ConsultaDAO();
		}
		return consultaDAO;
	}

	private Connection connection;
	private Statement statement;
	private static String BANCO = "consultorio";

	public ConsultaDAO() {

	}

	private void conectar() throws ClassNotFoundException, SQLException {
		connection = ConnectionFactory.connection();
		statement = connection.createStatement();
		String sql = "USE " + BANCO + ";";
		statement.executeUpdate(sql);
		System.out.println("Conectado!");
	}

	private void desconectar() {
		try {
			statement.close();
			connection.close();
			System.out.println("Desconectado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void insert(Consulta consulta) {
		try {

			conectar();

			StringBuffer buffer = new StringBuffer();
			
			desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	
	
	
	
	private String getFieldsDB() {
		return "data_hora_inicio, data_hora_fim, presenca, medico_cpf, atd_agenda_cpf, paciente_cpf";
	}

	protected String getFieldsValuesDB(Consulta c) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("data_hora_inicio=\"");
		buffer.append(c.getInicio());
		buffer.append("\", data_hora_fim=\"");
		buffer.append(c.getFim());
		buffer.append("\",presenca=\"");
		buffer.append(c.getPresenca());
		buffer.append("\", medico_cpf=\"");
		buffer.append(c.getMedico().getCpf());
		buffer.append("\", atd_agenda_cpf=\"");
		buffer.append(c.getMedico().getCpf());
		buffer.append("\", paciente_cpf=\"");
		buffer.append(c.getPaciente().getCpf());
		
		buffer.append("\"");

		return buffer.toString();
	}

	protected String getValuesDB(Paciente p) {

		StringBuffer buffer = new StringBuffer();
		

		return buffer.toString();
	}
}
