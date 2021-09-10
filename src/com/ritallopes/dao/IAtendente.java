package com.ritallopes.dao;

import com.ritallopes.entities.Atendente;
import com.ritallopes.entities.Paciente;

import java.util.ArrayList;

public interface IAtendente {
    public void update(Atendente atendente);
    public void insert(Atendente atendente);
    public Atendente search(String cpf);
    public void delete(Atendente atendente);
    public ArrayList<Atendente> listAtendentes();
}
