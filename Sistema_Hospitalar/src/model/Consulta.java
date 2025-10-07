package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta implements DadoPersistente {

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

    // Método para finalizar a consulta
    public void finalizarConsulta(String diagnostico, String prescricao) {
        // Verifica se o status da consulta é diferente de agendada
        if (!"Agendada".equals(this.statusConsulta)) {
            // Avisa que a a consulta já foi finalizada ou cancelada
            System.out.println("Está consulta já foi concluída ou cancelada.");
            return;
        }
        // Se não foi finalizada, muda o status para Concluida
        this.statusConsulta = "Concluida";
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;

        // Verifica se o paciente existe e adiciona ao historico
        if (this.paciente != null) {
            this.paciente.adicionarConsulta(this);
        }
        // Avisa ao usuário que a consulta foi finalizada
        System.out.println("Consulta finalizada com sucesso!");
    }

    // Metodo para cancelar a consulta
    public void cancelarConsulta() {
        // Verifica se o status da consulta é diferente de agendada
        if (!"Agendada".equals(this.statusConsulta)) {
            // Avisa que a consulta não pode ser cancelada
            System.out.println("Erro: apenas consultas agendadas podem ser canceladas.");
            return;
        }
        // Se não foi cancelada, muda os status pra Cancelada
        this.statusConsulta = "Cancelada";

        // Verifica se o medico existe e remove o horário.
        if (this.medico != null) {
            this.medico.removerHorario(this.dataHora);
        }
        // Avisa que a consulta foi cancelada
        System.out.println("Consulta cancelada com sucesso.");
    }

    // Método para calcular o preço da consulta
    public double calcularPrecoFinal() {
        // Se médico ou paciente for nulo
        if (this.medico == null || this.paciente == null) {
            // Retorna 0
            return 0.0;
        }

        // Pega o valor da consulta que é definido pelo médico
        double custoBase = this.medico.getCustoConsulta();

        // Repassa esse valor para o paciente calcular em plano de saude etc
        return this.paciente.calcularCustoConsulta(custoBase);
    }

    @Override
    public String toCsvString() {
        // Formata os dados do paciente especial para salvar

        // Formata o estilo da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Se a data for diferente de nula formata ela
        String dataFormatada;
        if (getDataHora() != null) {
            dataFormatada = getDataHora().format(formatter);
        } else {
            dataFormatada = "";
        }

        // Se cpf for diferente de nulo pega o cpf do paciente
        String cpfPaciente;
        if (getPaciente() != null) {
            cpfPaciente = getPaciente().getCpf();
        } else {
            cpfPaciente = "";
        }

        // Se o medico for diferente de nulo, pega o crm do medico
        String crmMedico;
        if (getMedico() != null) {
            crmMedico = getMedico().getCrm();
        } else {
            crmMedico = "";
        }

        return cpfPaciente + ";" + crmMedico + ";" + dataFormatada + ";" + getStatus() + ";" + getDiagnostico() + ";"
                + getPrescricao();
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
