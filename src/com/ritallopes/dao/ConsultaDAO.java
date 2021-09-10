package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ritallopes.connection.ConnectionFactory;
import com.ritallopes.entities.Consulta;

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
			buffer.append("INSERT INTO CONSULTA (");
			buffer.append(this.getFieldsDB());
			buffer.append(") VALUES (");
			buffer.append(getValuesDB(consulta));
			buffer.append(")");
			String sql = buffer.toString();


			statement.executeUpdate(sql);
			desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private ArrayList<Consulta> listConsultas(){
		try {
			conectar();
			String sql = "SELECT * FROM CONSULTA;";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<Consulta> cs = new ArrayList<Consulta>();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setInicio(rs.getString("data_hora_inicio"));
				consulta.setFim(rs.getString("data_hora_fim"));
				consulta.setPresenca(rs.getString("presenca"));
				consulta.setMedico(MedicoDAO.getInstance().search(rs.getString("medico_cpf")));
				consulta.setAtendente(AtendenteDAO.getInstance().search(rs.getString("atd_agenda_cpf")));
				consulta.setPaciente(PacienteDAO.getInstance().search(rs.getString("paciente_cpf")));
				cs.add(consulta);
			}
			desconectar();
			return cs;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
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
		buffer.append(c.getAtendente().getCpf());
		buffer.append("\", paciente_cpf=\"");
		buffer.append(c.getPaciente().getCpf());
		
		buffer.append("\"");

		return buffer.toString();
	}

	protected String getValuesDB(Consulta c) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("\"" + c.getInicio() + "\",\"");
		buffer.append(c.getFim() + "\",\"");
		buffer.append(c.getPresenca() + "\",\"");
		buffer.append(c.getMedico().getCpf() + "\",\"");
		buffer.append(c.getAtendente().getCpf() + "\",\"");
		buffer.append(c.getPaciente().getCpf()+ "\"");

		return buffer.toString();
	}
}
