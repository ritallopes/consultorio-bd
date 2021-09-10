package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ritallopes.entities.Paciente;

import com.ritallopes.connection.ConnectionFactory;

public class PacienteDAO implements IPaciente {
	private static PacienteDAO pacienteDAO;
	public static PacienteDAO getInstance() {
		if(pacienteDAO == null) {
			pacienteDAO = new PacienteDAO();
		}
		return pacienteDAO;		
	}

	
	private Connection connection;  
	private Statement statement;
	private static String BANCO = "consultorio";
	public PacienteDAO() {
		
	}
	
	private void conectar() throws ClassNotFoundException, SQLException  {
        connection = ConnectionFactory.connection();  
		statement = connection.createStatement();
		String sql ="USE "+BANCO+";";
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

	@Override
	public void update(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Paciente paciente) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(false);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente search(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Paciente> listPacientes() {
		try {
			conectar();
			String sql = "SELECT * FROM PACIENTE;";
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<Paciente> pacs = new ArrayList<Paciente>();
			while (rs.next()){
				Paciente paciente = new Paciente();
				paciente.setCpf(rs.getString("nome"));
				paciente.setNome(rs.getString("cpf"));
				paciente.setEmail(rs.getString("email"));
				paciente.setCep(rs.getString("cep"));
				paciente.setConvenio(rs.getString("convenio"));
				paciente.setDataCadastro(rs.getDate("data_cadastro").toString());
				pacs.add(paciente);
			}
			desconectar();
			return pacs;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private String getFieldsDB() {
		return "nome, cpf, email, cep, convenio, data_cadastro";
	}

}
