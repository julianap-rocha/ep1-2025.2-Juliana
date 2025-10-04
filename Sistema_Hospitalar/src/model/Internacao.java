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
    private static List<Internacao> internacoesAtivas = new ArrayList<>();

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

    // Método para chegar se o quarto está ocupado
    public static boolean verificarOcupacao(int quarto) {
        // Passa pelas internações ativas
        for (Internacao internacao : internacoesAtivas) {
            // Se encontrar um quarto com o mesmo número, retorna quarto ocupado
            if (internacao.getQuarto() == quarto) {
                return true;
            }
        }
        // O quarto está livre
        return false;
    }

    // Método para finalizar a internação
    public void finalizarInternacao() {
        // Verifica se a internação está ativa
        if (!"Internado".equals(this.statusInternacao)) {
            // Envia a mensagem pro usuário de que a internação não é ativa
            System.out.println("Erro: A internação não está ativa.");
            return;
        }

        // Se a internação existir atualiza o status
        this.statusInternacao = "Finalizada";
        // Registra o momento da alta
        this.dataSaida = LocalDateTime.now();

        // Remove da lista de ativos
        internacoesAtivas.remove(this);

        // Avisa ao paciente que a internação foi finalizada
        System.out.println("Internação do paciente " + this.paciente.getNome() + " finalizada.");
    }

    // Método para finalizar a internação
    public void cancelarInternacao() {
        // Verifica se a internação é ativa
        if (!"Internado".equals(this.statusInternacao)) {
            // Envia mensagem pro usuário que a internação não é ativa
            System.out.println("Erro: Esta internação não está ativa.");
            return;
        }
        // Altera o status da internação pra cancelada
        this.statusInternacao = "Cancelada";
        // Remove da lista de ativos
        internacoesAtivas.remove(this);

        // Avisa ao paciente que a itnernação foi cancelada
        System.out.println("Internação do paciente " + this.paciente.getNome() + " foi cancelada.");
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

}
