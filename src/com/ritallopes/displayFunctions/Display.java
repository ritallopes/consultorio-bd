package com.ritallopes.displayFunctions;

public class Display {
    private String separator = "-----------------------------------------";

    public void showIdentificationMenu(){
        System.out.println(separator);
        System.out.println("Digite 1 para Área do Paciente");
        System.out.println("Digite 2 para Área do Atendente");
        System.out.println("Digite 3 para Área do Médico");
        System.out.println("Digite 0 para encerrar o sistema");
    }

    public void showPatientMenu(){
        System.out.println(separator);
        System.out.println("--PACIENTE--");
        System.out.println("Digite 1 para consultas agendadas");
        System.out.println("Digite 2 para solicitar consulta");
        System.out.println("Digite 3 solicitar remarcarcao de consulta");
        System.out.println("Digite 4 solicitar desmarcarcao de consulta");
        System.out.println("Digite 5 para ver laudo");
        System.out.println("Digite 6 para efetuar pagamento");
        System.out.println("Digite 0 para voltar");

    }

    public void showAttendantMenu(){
        System.out.println(separator);
        System.out.println("--ATENDENTE--");
        System.out.println("Digite 1 para cadastrar paciente");
        System.out.println("Digite 2 para remover paciente");
        System.out.println("Digite 3 buscar paciente");
        System.out.println("Digite 4 para atualizar paciente");
        System.out.println("Digite 5 para agendar consulta");
        System.out.println("Digite 6 para atualizar consulta");
        System.out.println("Digite 7 para desmarcar consulta");
        System.out.println("Digite 0 para voltar");
    }

    public void showMedicMenu(){
        System.out.println(separator);
        System.out.println("--MEDICO--");
        System.out.println("Digite 1 para adicionar laudo");
        System.out.println("Digite 2 para ver laudo");
        System.out.println("Digite 3 para remover laudo");
        System.out.println("Digite 0 para voltar");
    }

}
