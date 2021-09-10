package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ritallopes.connection.ConnectionFactory;
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
			buffer.append("INSERT INTO PACIENTE (");
			buffer.append(this.getFieldsDB());
			buffer.append(") VALUES (");
			buffer.append(getValuesDB(paciente));
			buffer.append(")");
			String sql = buffer.toString();

			System.out.println("SQL para INSERIR que fica no EMPLOYEE : " + sql);

			statement.executeUpdate(sql);
			desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
