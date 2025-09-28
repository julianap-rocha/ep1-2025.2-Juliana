package model;

import java.time.LocalDateTime;

public class Consulta {

    // Atributos de Consulta
    private Paciente paciente; // Associação entre a Consulta e o Paciente
    private Medico medico; // Associação entre a Consulta e o Medico
    private LocalDateTime dataHora;
    private String consultorio;
    private String statusConsulta;
    private String diagnostico;
    private String prescricao;

    // Construtor vazio
    public Consulta() {

    }

    // Construtor com parâmetros
    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String consultorio) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.consultorio = consultorio;
        this.statusConsulta = "Agendada";
        this.diagnostico = "";
        this.prescricao = "";
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getStatus() {
        return statusConsulta;
    }

    public void setStatus(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

}
