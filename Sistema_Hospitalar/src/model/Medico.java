package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Medico herda de Pessoa para utilizar o atributo em comum
public class Medico extends Pessoa {

    // Atributos classe Medico
    private String crm;
    private String especialidade;
    private double custoConsulta;
    private List<LocalDateTime> agendaHorarios;

    // Construtor vazio
    public Medico() {

    }

    // Construtor com parâmetros
    public Medico(String nome, String crm, String especialidade, double custoConsulta) {
        super(nome);
        this.crm = crm;
        this.especialidade = especialidade;
        this.custoConsulta = custoConsulta;
        this.agendaHorarios = new ArrayList<>();
    }

    // Método para remover o horario
    public void removerHorario(LocalDateTime horario) {
        // Remove o horário da agenda.
        this.agendaHorarios.remove(horario);
    }

    // Getters e Setters
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getCustoConsulta() {
        return custoConsulta;
    }

    public void setCustoConsulta(double custoConsulta) {
        this.custoConsulta = custoConsulta;
    }

    public List<LocalDateTime> getAgendaHorarios() {
        return agendaHorarios;
    }

    public void setAgendaHorarios(List<LocalDateTime> agendaHorarios) {
        this.agendaHorarios = agendaHorarios;
    }

}
