package com.ritallopes.dao;

import com.ritallopes.entities.Medico;
import java.util.ArrayList;

public interface IMedico {
    public void update(Medico medico);
    public void insert(Medico medico);
    public Medico search(String cpf);
    public void delete(Medico medico);
    public ArrayList<Medico> listMedicos();
}
