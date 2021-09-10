package com.ritallopes.entities;

import lombok.*;

public class Atendente extends Funcionario{

    public Atendente(){}
    public Atendente(String nome, String cpf, String telefone, String email, String cep, String dataContratacao) {
        super(nome, cpf, telefone, email, cep, dataContratacao);
    }

    public String toString() {

        return super.toString();
    }

}
