package com.ritallopes.entities;

public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public String toString() {
        return "CEP:"+this.cep+", Rua: "+this.rua+", Bairro:"+this.bairro+", Cidade:"+this.cidade+"Estado:"+this.estado+"País:"+this.pais+", ";
    }

}
