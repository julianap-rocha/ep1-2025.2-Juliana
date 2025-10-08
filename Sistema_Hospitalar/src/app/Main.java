package app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Consulta;
import model.Internacao;
import model.Medico;
import model.Paciente;
import model.PacienteComum;
import model.PacienteEspecial;
import model.PlanoDeSaude;
import util.Persistencia;
import util.Relatorios;

public class Main {

    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<PlanoDeSaude> planos = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {

        Persistencia.carregarDados(planos, medicos, pacientes, consultas);

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== SISTEMA HOSPITALAR =====");
            System.out.println("1. Gerenciar Cadastros");
            System.out.println("2. Gerenciar Consultas");
            System.out.println("3. Gerenciar Internações");
            System.out.println("4. Exibir Relatórios");
            System.out.println("0. Salvar e Sair");
            System.out.print("Opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        menuCadastros(sc);
                        break;
                    case 2:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        menuConsultas(sc);
                        break;
                    case 3:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        menuInternacoes(sc);
                        break;
                    case 4:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        menuRelatorios(sc);
                        break;
                    case 0:
                        Persistencia.salvarDados(planos, medicos, pacientes, consultas);
                        System.out.println("Sistema encerrado. Dados salvos.");
                        executando = false;
                        break;
                    default:
                        System.out.println("ERRO: Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, digite apenas números para as opções do menu.");
                sc.nextLine();
            }
        }
        sc.close();
    }

    public static void menuCadastros(Scanner sc) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Menu de Cadastros ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Cadastrar Plano de Saúde");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        cadastrarPaciente(sc);
                        break;
                    case 2:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        cadastrarMedico(sc);
                        break;
                    case 3:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        cadastrarPlano(sc);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("ERRO: Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public static void menuConsultas(Scanner sc) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Menu de Consultas ---");
            System.out.println("1. Agendar Nova Consulta");
            System.out.println("2. Finalizar Consulta Agendada");
            System.out.println("3. Cancelar Consulta Agendada");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        agendarConsulta(sc);
                        break;
                    case 2:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        finalizarConsulta(sc);
                        break;
                    case 3:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        cancelarConsulta(sc);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("ERRO: Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public static void menuInternacoes(Scanner sc) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Menu de Internações ---");
            System.out.println("1. Realizar Nova Internação");
            System.out.println("2. Finalizar Internação (Dar Alta)");
            System.out.println("3. Cancelar Internação");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        realizarNovaInternacao(sc);
                        break;
                    case 2:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        finalizarInternacao(sc);
                        break;
                    case 3:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        cancelarInternacao(sc);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("ERRO: Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public static void menuRelatorios(Scanner sc) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Menu de Relatórios ---");
            System.out.println("1. Listar Pacientes");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Listar Pacientes Internados");
            System.out.println("4. Exibir Estatísticas Gerais");
            System.out.println("5. Relatório de Plano de Saúde");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        Relatorios.listarPacientes(pacientes);
                        break;
                    case 2:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        Relatorios.listarMedicos(medicos, consultas);
                        break;
                    case 3:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        Relatorios.listarInternacoes(Internacao.getInternacoesAtivas());
                        break;
                    case 4:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        Relatorios.listarEstatisticasGerais(consultas);
                        break;
                    case 5:
                        for (int i = 0; i < 50; i++) {
                            System.out.println();
                        }
                        System.out.print("Digite o nome do Plano de Saúde: ");
                        String nomePlano = sc.nextLine();
                        Relatorios.listarPlanoDeSaude(nomePlano, pacientes);
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("ERRO: Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public static void cadastrarPaciente(Scanner sc) {
        System.out.println("\n--- Cadastro de Paciente ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        try {
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.print("Possui plano de saúde? (S/N): ");
            String possuiPlano = sc.nextLine();

            if (possuiPlano.equalsIgnoreCase("S")) {
                if (planos.isEmpty()) {
                    System.out.println("ERRO: Nenhum plano cadastrado.");
                    return;
                }

                System.out.println("Selecione o plano:");
                for (int i = 0; i < planos.size(); i++) {
                    System.out.println((i + 1) + ") " + planos.get(i).getNomePlano());
                }
                System.out.print("Opção: ");
                int opPlano = sc.nextInt() - 1;
                sc.nextLine();

                if (opPlano >= 0 && opPlano < planos.size()) {
                    PlanoDeSaude planoEscolhido = planos.get(opPlano);
                    pacientes.add(new PacienteEspecial(nome, cpf, idade, planoEscolhido));
                    System.out.println("Paciente (Especial) cadastrado com sucesso!");
                } else {
                    System.out.println("ERRO: Opção de plano inválida.");
                }
            } else {
                System.out.print("Método de pagamento: ");
                String metodoPagamento = sc.nextLine();
                pacientes.add(new PacienteComum(nome, cpf, idade, metodoPagamento));
                System.out.println("Paciente (Comum) cadastrado com sucesso!");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Idade inválida. Use apenas números.");
            sc.nextLine();
        }
    }

    public static void cadastrarMedico(Scanner sc) {
        System.out.println("\n--- Cadastro de Médico ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CRM: ");
        String crm = sc.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = sc.nextLine();

        try {
            System.out.print("Custo da Consulta: R$ ");
            double custo = sc.nextDouble();
            sc.nextLine();

            medicos.add(new Medico(nome, crm, especialidade, custo));
            System.out.println("Médico cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Custo inválido. Use apenas números.");
            sc.nextLine();
        }
    }

    public static void cadastrarPlano(Scanner sc) {
        System.out.println("\n--- Cadastro de Plano de Saúde ---");
        System.out.print("Nome do Plano: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        try {
            System.out.print("Desconto Base (ex: 0.1 para 10%): ");
            double desconto = sc.nextDouble();
            sc.nextLine();

            System.out.print("Permite internação especial? (S/N): ");
            boolean permite = sc.nextLine().equalsIgnoreCase("S");

            planos.add(new PlanoDeSaude(nome, desconto, descricao, permite));
            System.out.println("Plano de Saúde cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Desconto inválido. Use apenas números.");
            sc.nextLine();
        }
    }

    public static void agendarConsulta(Scanner sc) {
        System.out.println("\n--- Agendar Nova Consulta ---");
        if (pacientes.isEmpty() || medicos.isEmpty()) {
            System.out.println("ERRO: É necessário ter pacientes e médicos cadastrados.");
            return;
        }

        try {
            System.out.println("Selecione o paciente:");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + ") " + pacientes.get(i).getNome());
            }
            System.out.print("Opção: ");
            int opPaciente = sc.nextInt() - 1;
            sc.nextLine();

            System.out.println("\nSelecione o médico:");
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println((i + 1) + ") Dr(a). " + medicos.get(i).getNome());
            }
            System.out.print("Opção: ");
            int opMedico = sc.nextInt() - 1;
            sc.nextLine();

            if (opPaciente < 0 || opPaciente >= pacientes.size() || opMedico < 0 || opMedico >= medicos.size()) {
                System.out.println("ERRO: Seleção de paciente ou médico inválida.");
                return;
            }

            Paciente p = pacientes.get(opPaciente);
            Medico m = medicos.get(opMedico);

            System.out.println("Digite a data e hora da consulta:");
            System.out.print("Ano (ex: 2025): ");
            int ano = sc.nextInt();
            System.out.print("Mês (1-12): ");
            int mes = sc.nextInt();
            System.out.print("Dia: ");
            int dia = sc.nextInt();
            System.out.print("Hora (0-23): ");
            int hora = sc.nextInt();
            System.out.print("Minuto (0-59): ");
            int minuto = sc.nextInt();
            sc.nextLine();

            LocalDateTime dataHora = LocalDateTime.of(ano, mes, dia, hora, minuto);

            if (!m.verificarDisponibilidade(dataHora)) {
                System.out.println("ERRO: O Dr(a). " + m.getNome() + " não está disponível neste horário.");
                return;
            }

            System.out.print("Local (ex: Consultório 101): ");
            String local = sc.nextLine();

            consultas.add(new Consulta(p, m, dataHora, local));
            m.adicionarHorario(dataHora);

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Entrada numérica inválida.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("ERRO inesperado ao agendar consulta: " + e.getMessage());
        }
    }

    public static void finalizarConsulta(Scanner sc) {
        System.out.println("\n--- Finalizar Consulta Agendada ---");

        List<Consulta> consultasAgendadas = new ArrayList<>();
        for (Consulta c : consultas) {
            if ("Agendada".equals(c.getStatus())) {
                consultasAgendadas.add(c);
            }
        }

        if (consultasAgendadas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada para finalizar.");
            return;
        }

        System.out.println("Selecione a consulta para finalizar:");
        for (int i = 0; i < consultasAgendadas.size(); i++) {
            Consulta c = consultasAgendadas.get(i);
            System.out.println(
                    (i + 1) + ") Paciente: " + c.getPaciente().getNome() + " com Dr(a). " + c.getMedico().getNome());
        }

        try {
            System.out.print("Opção: ");
            int opcao = sc.nextInt() - 1;
            sc.nextLine();

            if (opcao >= 0 && opcao < consultasAgendadas.size()) {
                Consulta consultaEscolhida = consultasAgendadas.get(opcao);

                System.out.print("Diagnóstico: ");
                String diagnostico = sc.nextLine();
                System.out.print("Prescrição: ");
                String prescricao = sc.nextLine();

                consultaEscolhida.finalizarConsulta(diagnostico, prescricao);
            } else {
                System.out.println("ERRO: Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Por favor, digite um número válido.");
            sc.nextLine();
        }
    }

    public static void cancelarConsulta(Scanner sc) {
        System.out.println("\n--- Cancelar Consulta Agendada ---");

        List<Consulta> consultasAgendadas = new ArrayList<>();
        for (Consulta c : consultas) {
            if ("Agendada".equals(c.getStatus())) {
                consultasAgendadas.add(c);
            }
        }

        if (consultasAgendadas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada para cancelar.");
            return;
        }

        System.out.println("Selecione a consulta para cancelar:");
        for (int i = 0; i < consultasAgendadas.size(); i++) {
            Consulta c = consultasAgendadas.get(i);
            System.out.println(
                    (i + 1) + ") Paciente: " + c.getPaciente().getNome() + " com Dr(a). " + c.getMedico().getNome());
        }

        try {
            System.out.print("Opção: ");
            int opcao = sc.nextInt() - 1;
            sc.nextLine();

            if (opcao >= 0 && opcao < consultasAgendadas.size()) {
                Consulta consultaEscolhida = consultasAgendadas.get(opcao);
                consultaEscolhida.cancelarConsulta();
            } else {
                System.out.println("ERRO: Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Por favor, digite um número válido.");
            sc.nextLine();
        }
    }

    public static void realizarNovaInternacao(Scanner sc) {
        System.out.println("\n--- Realizar Nova Internação ---");

        if (pacientes.isEmpty() || medicos.isEmpty()) {
            System.out.println("ERRO: É necessário ter pacientes e médicos cadastrados.");
            return;
        }

        try {
            System.out.println("Selecione o paciente:");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + ") " + pacientes.get(i).getNome());
            }
            System.out.print("Opção: ");
            int opPaciente = sc.nextInt() - 1;
            sc.nextLine();

            System.out.println("\nSelecione o médico responsável:");
            for (int i = 0; i < medicos.size(); i++) {
                System.out.println((i + 1) + ") Dr(a). " + medicos.get(i).getNome());
            }
            System.out.print("Opção: ");
            int opMedico = sc.nextInt() - 1;
            sc.nextLine();

            if (opPaciente < 0 || opPaciente >= pacientes.size() || opMedico < 0 || opMedico >= medicos.size()) {
                System.out.println("ERRO: Seleção de paciente ou médico inválida.");
                return;
            }

            Paciente pacienteEscolhido = pacientes.get(opPaciente);
            Medico medicoEscolhido = medicos.get(opMedico);

            System.out.print("Digite o número do quarto: ");
            int numeroQuarto = sc.nextInt();
            sc.nextLine();

            if (Internacao.verificarOcupacao(numeroQuarto)) {
                System.out.println("ERRO: O quarto " + numeroQuarto + " já está ocupado.");
                return;
            }

            System.out.print("Digite o custo diário: R$ ");
            double custoDiario = sc.nextDouble();
            sc.nextLine();

            new Internacao(pacienteEscolhido, medicoEscolhido, numeroQuarto, custoDiario);
            System.out.println("Paciente " + pacienteEscolhido.getNome() + " internado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("ERRO: Entrada numérica inválida.");
            sc.nextLine();
        }
    }

    public static void finalizarInternacao(Scanner sc) {
        System.out.println("\n--- Finalizar Internação (Dar Alta) ---");

        List<Internacao> internacoesAtivas = Internacao.getInternacoesAtivas();

        if (internacoesAtivas.isEmpty()) {
            System.out.println("Nenhuma internação ativa no momento.");
            return;
        }

        System.out.println("Selecione a internação para dar alta:");
        for (int i = 0; i < internacoesAtivas.size(); i++) {
            Internacao internacao = internacoesAtivas.get(i);
            System.out.println((i + 1) + ") Paciente: " + internacao.getPaciente().getNome() + " | Quarto: "
                    + internacao.getQuarto());
        }

        try {
            System.out.print("Opção: ");
            int opcao = sc.nextInt() - 1;
            sc.nextLine();

            if (opcao >= 0 && opcao < internacoesAtivas.size()) {
                Internacao internacaoEscolhida = internacoesAtivas.get(opcao);
                internacaoEscolhida.finalizarInternacao();
            } else {
                System.out.println("ERRO: Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Por favor, digite um número válido.");
            sc.nextLine();
        }
    }

    public static void cancelarInternacao(Scanner sc) {
        System.out.println("\n--- Cancelar Internação Ativa ---");

        List<Internacao> internacoesAtivas = Internacao.getInternacoesAtivas();

        if (internacoesAtivas.isEmpty()) {
            System.out.println("Nenhuma internação ativa para cancelar.");
            return;
        }

        System.out.println("Selecione a internação para cancelar:");
        for (int i = 0; i < internacoesAtivas.size(); i++) {
            Internacao internacao = internacoesAtivas.get(i);
            System.out.println((i + 1) + ") Paciente: " + internacao.getPaciente().getNome() + " | Quarto: "
                    + internacao.getQuarto());
        }

        try {
            System.out.print("Opção: ");
            int opcao = sc.nextInt() - 1;
            sc.nextLine();

            if (opcao >= 0 && opcao < internacoesAtivas.size()) {
                Internacao internacaoEscolhida = internacoesAtivas.get(opcao);
                internacaoEscolhida.cancelarInternacao();
            } else {
                System.out.println("ERRO: Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Por favor, digite um número válido.");
            sc.nextLine();
        }
    }
}
