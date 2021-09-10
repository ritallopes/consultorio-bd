package com.ritallopes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

import com.ritallopes.connection.ConnectionFactory;
import com.ritallopes.entities.Atendente;

public class AtendenteDAO implements IAtendente{
    private static AtendenteDAO atendenteDAO;

    public static AtendenteDAO getInstance() {
        if (atendenteDAO == null) {
            atendenteDAO = new AtendenteDAO();
        }
        return atendenteDAO;
    }

    private Connection connection;
    private Statement statement;
    private static String BANCO = "consultorio";

    public AtendenteDAO() {

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
    public void update(Atendente atendente) {
        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE ATENDENTE SET ");
            buffer.append(getFieldsValuesDB(atendente));
            buffer.append(" WHERE CPF=");
            buffer.append(atendente.getCpf());
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
    public void insert(Atendente atendente) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO ATENDENTE (");
            buffer.append(this.getFieldsDB());
            buffer.append(") VALUES (");
            buffer.append(getValuesDB(atendente));
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
    public Atendente search(String cpf) {

        try {
            conectar();
            String sql = "SELECT * FROM ATENDENTE WHERE cpf = \"" + cpf+"\";";

            ResultSet rs = statement.executeQuery(sql);
            Atendente a = new Atendente();
            if (rs.next()) {
                a.setCpf(rs.getString("cpf"));
                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setDataContratacao(rs.getString("data_contratacao"));
                a.setCep(rs.getString("cep"));
            }

            desconectar();
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Atendente atendente) {
        try {
            conectar();
            String sql = "DELETE FROM ATENDENTE WHERE cpf=\"" + atendente.getCpf() + "\";";
            statement.executeUpdate(sql);
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Atendente> listAtendentes() {
        try {
            conectar();
            String sql = "SELECT * FROM ATENDENTE;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Atendente> atends = new ArrayList<Atendente>();
            while (rs.next()) {
                Atendente atendente = new Atendente();
                atendente.setCpf(rs.getString("cpf"));
                atendente.setNome(rs.getString("nome"));
                atendente.setEmail(rs.getString("email"));
                atendente.setCep(rs.getString("cep"));
                atendente.setDataContratacao(rs.getDate("data_contratacao").toString());
                atends.add(atendente);
            }
            desconectar();
            return atends;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFieldsDB() {
        return "cpf, nome, email, cep, data_contratacao";
    }

    protected String getFieldsValuesDB(Atendente a) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("cpf=\"");
        buffer.append(a.getCpf());
        buffer.append("\", nome=\"");
        buffer.append(a.getNome());
        buffer.append("\", email=\"");
        buffer.append(a.getEmail());
        buffer.append("\", cep=\"");
        buffer.append(a.getCep());
        buffer.append("\", data_contratacao=\"");
        buffer.append(a.getDataContratacao());
        buffer.append("\"");

        return buffer.toString();
    }

    protected String getValuesDB(Atendente a) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("\"" + a.getCpf() + "\",\"");
        buffer.append(a.getNome() + "\",\"");
        buffer.append(a.getEmail() + "\",\"");
        buffer.append(a.getCep() + "\",\"");
        buffer.append(a.getDataContratacao() + "\"");

        return buffer.toString();
    }
}
