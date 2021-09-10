package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

import com.ritallopes.connection.ConnectionFactory;
import com.ritallopes.entities.Medico;

public class MedicoDAO implements IMedico{
    private static MedicoDAO medicoDAO;

    public static MedicoDAO getInstance() {
        if (medicoDAO == null) {
            medicoDAO = new MedicoDAO();
        }
        return medicoDAO;
    }

    private Connection connection;
    private Statement statement;
    private static String BANCO = "consultorio";

    public MedicoDAO() {

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

    @Override
    public void update(Medico medico) {
        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE MEDICO SET ");
            buffer.append(getFieldsValuesDB(medico));
            buffer.append(" WHERE CPF=");
            buffer.append(medico.getCpf());
            buffer.append(";");
            String sql = buffer.toString();
            statement.executeUpdate(sql);
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Medico medico) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO MEDICO (");
            buffer.append(this.getFieldsDB());
            buffer.append(") VALUES (");
            buffer.append(getValuesDB(medico));
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

    @Override
    public Medico search(String cpf) {

        try {
            conectar();
            String sql = "SELECT * FROM MEDICO WHERE cpf = \"" + cpf+"\";";

            ResultSet rs = statement.executeQuery(sql);
            Medico m = new Medico();
            if (rs.next()) {
                m.setCpf(rs.getString("cpf"));
                m.setNome(rs.getString("nome"));
                m.setEmail(rs.getString("email"));
                m.setCrm(rs.getString("crm"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setDataContratacao(rs.getDate("data_contratacao").toString());
                m.setCep(rs.getString("cep"));
            }

            desconectar();
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Medico medico) {
        try {
            conectar();
            String sql = "DELETE FROM MEDICO WHERE cpf=\"" + medico.getCpf() + "\";";
            statement.executeUpdate(sql);
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Medico> listMedicos() {
        try {
            conectar();
            String sql = "SELECT * FROM MEDICO;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Medico> medicos = new ArrayList<Medico>();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCpf(rs.getString("cpf"));
                medico.setNome(rs.getString("nome"));
                medico.setEmail(rs.getString("email"));
                medico.setCep(rs.getString("cep"));
                medico.setCrm(rs.getString("crm"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setDataContratacao(rs.getDate("data_contratacao").toString());
                medicos.add(medico);
            }
            desconectar();
            return medicos;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFieldsDB() {
        return "cpf, nome, email, cep, crm, especialiadade, data_contratacao";
    }

    protected String getFieldsValuesDB(Medico m) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("cpf=\"");
        buffer.append(m.getCpf());
        buffer.append("\", nome=\"");
        buffer.append(m.getNome());
        buffer.append("\", email=\"");
        buffer.append(m.getEmail());
        buffer.append("\", cep=\"");
        buffer.append(m.getCep());
        buffer.append("\", crm=\"");
        buffer.append(m.getCrm());
        buffer.append("\", especialidade=\"");
        buffer.append(m.getEspecialidade());
        buffer.append("\", data_contratacao=\"");
        buffer.append(m.getDataContratacao());
        buffer.append("\"");

        return buffer.toString();
    }

    protected String getValuesDB(Medico m) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("\"" + m.getCpf() + "\",\"");
        buffer.append(m.getNome() + "\",\"");
        buffer.append(m.getEmail() + "\",\"");
        buffer.append(m.getCep() + "\",\"");
        buffer.append(m.getCrm() + "\",\"");
        buffer.append(m.getDataContratacao() + "\",\"");
        buffer.append(m.getEspecialidade() + "\"");

        return buffer.toString();
    }
}
