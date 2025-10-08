package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import model.Consulta;
import model.Internacao;
import model.Medico;
import model.Paciente;

public class Relatorios {

    // Define um formato padrão para data e hora
    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Mostra todos os pacientes cadastrados e o histórico de consultas
    public static void listarPacientes(List<Paciente> listaDePacientes) {
        System.out.println("\n--- Pacientes Cadastrados ---");
        // Verifica se a lista de pacientes ta vazia
        if (listaDePacientes.isEmpty()) {
            // Avisa ao usuário
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        // Passa pelos objetos da lista
        for (Paciente paciente : listaDePacientes) {
            System.out.println(
                    "- " + paciente.getNome() + " | CPF: " + paciente.getCpf() + " | Idade: " + paciente.getIdade());

            // Verifica se o paciente tem histórico
            if (paciente.getHistoricoConsultas() == null || paciente.getHistoricoConsultas().isEmpty()) {
                System.out.println("Nenhuma consulta no histórico.");
            } else {
                System.out.println("Histórico:");
                // Passa pelas consultas do histórico
                for (Consulta consulta : paciente.getHistoricoConsultas()) {
                    // Verifica se a consulta tem médico e data e hora
                    if (consulta != null && consulta.getMedico() != null && consulta.getDataHora() != null) {
                        System.out.println("    - Consulta com Dr(a). " + consulta.getMedico().getNome() + " em "
                                + consulta.getDataHora().format(FORMATADOR_DATA_HORA));
                    }
                }
            }
        }
    }

    // Mostra todos os médicos e quantidade de consultas que cada um realizou
    public static void listarMedicos(List<Medico> medicos, List<Consulta> todasAsConsultas) {
        System.out.println("\n--- Médicos Cadastrados ---");
        // Verifica se a lista de médicos está vazia
        if (medicos.isEmpty()) {
            // Avisa ao usupario
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        // Passa pela lista de médicos
        for (Medico medico : medicos) {
            // Inicia um contador de consultas
            int consultasRealizadas = 0;
            for (Consulta consulta : todasAsConsultas) {
                // Verifica se tem médico, se é o mesmo médico do for e se tem o status de
                // concluida
                if (consulta.getMedico() != null && consulta.getMedico().equals(medico)
                        && "Concluida".equals(consulta.getStatus())) {
                    consultasRealizadas++;
                }
            }

            System.out.println("- Dr(a). " + medico.getNome() + " (CRM: " + medico.getCrm() + ") | "
                    + medico.getEspecialidade() + " | Consultas Realizadas: " + consultasRealizadas);
        }
    }

    // Mostra os pacientes cadastrados e o tempo de internação
    public static void listarInternacoes(List<Internacao> internacoesAtivas) {
        System.out.println("\n--- Pacientes Internados Atualmente ---");
        // Verifica se a internação é vazia ou nula
        if (internacoesAtivas == null || internacoesAtivas.isEmpty()) {
            // Avisa ao usuário
            System.out.println("Nenhum paciente internado no momento.");
            return;
        }

        // Passa pela lista de internacoes ativas
        for (Internacao internacao : internacoesAtivas) {
            // verifica se o paciente, medico e data não são nulos
            if (internacao.getPaciente() != null && internacao.getMedico() != null
                    && internacao.getDataEntrada() != null) {
                // Pega o momento atual
                LocalDateTime agora = LocalDateTime.now();
                // Calcula as horas desde a entrada até o momento atual
                long horas = ChronoUnit.HOURS.between(internacao.getDataEntrada(), agora);

                System.out.println(
                        "- Paciente: " + internacao.getPaciente().getNome() + " | Quarto: " + internacao.getQuarto()
                                + " | Médico: Dr(a). " + internacao.getMedico().getNome() + " | Tempo: " + horas + "h");
            }
        }
    }

    // Mostra as estatísticas simples
    public static void listarEstatisticasGerais(List<Consulta> todasAsConsultas) {
        System.out.println("\n--- Estatísticas Gerais ---");
        // Verifica se a consulta é vazia ou nula
        if (todasAsConsultas == null || todasAsConsultas.isEmpty()) {
            // Avisa ao usuario
            System.out.println("Nenhuma consulta registrada.");
            return;
        }

        // Inicializa as variáveis
        String especialidadeMaisProcurada = "Nenhuma";
        int maximoConsultas = 0;

        List<String> especialidadesUnicas = new ArrayList<>();

        // Passa pela lista de consultas
        for (Consulta consulta : todasAsConsultas) {
            if (consulta.getMedico() != null) {
                String especialidadeAtual = consulta.getMedico().getEspecialidade();

                if (!especialidadesUnicas.contains(especialidadeAtual)) {
                    // Inicia a variável para contar as especialidades
                    int contagem = 0;
                    // Passa pela lista de novo para contar quantas vezes a especialidade aparece
                    for (Consulta c : todasAsConsultas) {
                        if (c.getMedico() != null && c.getMedico().getEspecialidade().equals(especialidadeAtual)) {
                            contagem++;
                        }
                    }

                    // Verifica se é a maior contagem
                    if (contagem > maximoConsultas) {
                        // Atualiza o valor
                        maximoConsultas = contagem;
                        especialidadeMaisProcurada = especialidadeAtual;
                    }
                    // Atualiza a especialidadeAtual para não contar novamente
                    especialidadesUnicas.add(especialidadeAtual);
                }
            }
        }
        System.out.println("- Especialidade mais procurada: " + especialidadeMaisProcurada + " (" + maximoConsultas
                + " consultas)");
        System.out.println("- Total de consultas no sistema: " + todasAsConsultas.size());
    }

    // Mostra o relatório de um plano específico
    public static void listarPlanoDeSaude(String nomePlano, List<Paciente> pacientes) {
        System.out.println("\n--- Relatório do Plano: " + nomePlano + " ---");
        int numeroPacientesNoPlano = 0;
        double totalEconomizado = 0;

        // Passa pela lista de pacientes no plano
        for (Paciente p : pacientes) {
            if (p.possuiPlano(nomePlano)) {
                // Conta o número de pacientes
                numeroPacientesNoPlano++;
            }
        }

        // Passa pela lista de novo
        for (Paciente p : pacientes) {
            if (p.possuiPlano(nomePlano)) {

                // Pega os pacientes do plano e passa pelo histórico de consultas deles
                for (Consulta c : p.getHistoricoConsultas()) {
                    // Verifica se a consulta é diferente de nula, se tem médico e se é concluida
                    if (c != null && c.getMedico() != null && "Concluida".equals(c.getStatus())) {
                        // Calcula o valor da consulta
                        double custoBase = c.getMedico().getCustoConsulta();
                        double custoFinal = c.calcularPrecoFinal();
                        totalEconomizado += (custoBase - custoFinal);
                    }
                }
            }
        }

        System.out.println("- Total de pacientes no plano: " + numeroPacientesNoPlano);
        System.out.println("- Valor total economizado em consultas: R$ " + String.format("%.2f", totalEconomizado));
    }
}
