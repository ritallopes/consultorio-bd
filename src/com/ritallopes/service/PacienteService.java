package com.ritallopes.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ritallopes.dao.ConsultaDAO;
import com.ritallopes.entities.Consulta;

public class PacienteService {

    public void mostrarConsultas(){
        ArrayList<Consulta> consultas = ConsultaDAO.getInstance().listConsultas();

        int index = 0;
        for (Consulta cs: consultas) {
            index++;
            System.out.println(index + " - "+ cs.toString());
        }
    }
}
