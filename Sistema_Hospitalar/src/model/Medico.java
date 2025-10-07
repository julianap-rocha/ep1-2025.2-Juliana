package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Medico herda de Pessoa para utilizar o atributo em comum
public class Medico extends Pessoa implements DadoPersistente {

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

    // Método para adicionar horário
    public void adicionarHorario(LocalDateTime horario) {
        // Verifica se o horário está disponível
        if (verificarDisponibilidade(horario)) {
            /// Se estiver disponível adiciona na agenda
            this.agendaHorarios.add(horario);
            // Mensagem de confirmação para o usuário
            System.out.println("Horário agendado para: " + horario);
        } else {
            // Se não tiver horário emite o aviso
            System.out.println("Erro: O horário está ocupado.");
        }
    }

    // Verifica disponinonilidade na agenda
    public boolean verificarDisponibilidade(LocalDateTime horario) {
        // Passa por todos os horários já agendados
        for (LocalDateTime horarioAgendado : this.agendaHorarios) {
            // Se encontrar um horário no mesmo que queremos agendar retorna falso
            if (horarioAgendado.equals(horario)) {
                return false;
            }
        }
        // Se não encontrar retorna verdadeiro
        return true;
    }

    // Método para remover o horario
    public void removerHorario(LocalDateTime horario) {
        // Remove o horário da agenda.
        this.agendaHorarios.remove(horario);
    }

    @Override
    public String toCsvString() {
        //Formata os dados do medico para salvar
        return getNome() + "," + getCrm() + "," + getEspecialidade() + "," + getCustoConsulta();
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
