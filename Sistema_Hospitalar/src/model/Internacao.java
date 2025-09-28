package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Internacao {

    // Atributos de Internacao
    private Paciente paciente; // Associação entre a Internacao e o Paciente
    private Medico medico; // Associação entre a Internacao e o Medico
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int quarto;
    private double custo;
    private String statusInternacao;
    private List<Internacao> internacoesAtivas = new ArrayList<>();

    // Construtor vazio
    public Internacao() {

    }

    // Construtor com parâmetros
    public Internacao(Paciente paciente, Medico medico, int quarto, double custo) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataEntrada = LocalDateTime.now();
        this.dataSaida = null;
        this.quarto = quarto;
        this.custo = custo;
        this.statusInternacao = "Internado";
        internacoesAtivas.add(this);
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

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getStatusInternacao() {
        return statusInternacao;
    }

    public void setStatusInternacao(String statusInternacao) {
        this.statusInternacao = statusInternacao;
    }

    public List<Internacao> getInternacoesAtivas() {
        return internacoesAtivas;
    }

    public void setInternacoesAtivas(List<Internacao> internacoesAtivas) {
        this.internacoesAtivas = internacoesAtivas;
    }

}
