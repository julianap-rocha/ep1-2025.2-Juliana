package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Consulta;
import model.DadoPersistente;
import model.Medico;
import model.Paciente;
import model.PacienteComum;
import model.PacienteEspecial;
import model.PlanoDeSaude;

public class Persistencia {

    // Nome dos arquivos que os dados vão ser salvos
    private static final String PLANOS_CSV = "planos.csv";
    private static final String MEDICOS_CSV = "medicos.csv";
    private static final String PACIENTES_CSV = "pacientes.csv";
    private static final String CONSULTAS_CSV = "consultas.csv";

    // Padrao pra data ser formatada
    private static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Método para salvar os arquivos do sistema
    public static void salvarDados(List<PlanoDeSaude> planos, List<Medico> medicos, List<Paciente> pacientes,
            List<Consulta> consultas) {
        try {
            // Chama o método para salvar as listas
            salvarEntidades(planos, PLANOS_CSV);
            salvarEntidades(medicos, MEDICOS_CSV);
            salvarEntidades(pacientes, PACIENTES_CSV);
            salvarEntidades(consultas, CONSULTAS_CSV);

            // Exibe mensagem se o salvamento não teve erros
            System.out.println("Dados salvos");
            // Se ocorrer um erro
        } catch (IOException e) {
            // Exibe uma mensagem no terminal
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Méotodo para salvar a lista no arquivo csv
    private static void salvarEntidades(List<? extends DadoPersistente> entidades, String nomeArquivo)
            throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {

            // Passa pelas entidades da lista
            for (DadoPersistente entidade : entidades) {

                // Chama o método toCsvString
                writer.println(entidade.toCsvString());
            }
        }
    }

    public static void carregarDados(List<PlanoDeSaude> planos, List<Medico> medicos, List<Paciente> pacientes,
            List<Consulta> consultas) {
        // Carrega os dados independentes
        carregarPlanos(planos);
        carregarMedicos(medicos);

        // Carrega os dados com associação
        carregarPacientes(pacientes, planos);
        carregarConsultas(consultas, pacientes, medicos);

        // Exibe uma mensagem avisando
        System.out.println("Dados carregados");
    }

    private static void carregarPlanos(List<PlanoDeSaude> planos) {
        // Cria um arquivo
        File arquivo = new File(PLANOS_CSV);
        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            // Se não existir avisa ao usuário
            System.out.println("Arquivo de planos não encontrado, iniciando com a lista vazia.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            // Le as linhas do arquivo
            while ((linha = reader.readLine()) != null) {
                // Converte o csv em array
                String[] dados = linha.split(",");
                // Cria e adiciona o plano de saúde na lista
                PlanoDeSaude plano = new PlanoDeSaude(dados[0], Double.parseDouble(dados[2]), dados[1],
                        Boolean.parseBoolean(dados[3]));
                planos.add(plano);
            }
        } catch (IOException e) {
            // Se tiver erro exibe a mensagem
            System.err.println("Erro ao carregar os planos: " + e.getMessage());
        }
    }

    private static void carregarMedicos(List<Medico> medicos) {
        // Cria um arquivo
        File arquivo = new File(MEDICOS_CSV);
        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            // Se não existir avisa ao usuário
            System.out.println("Arquivo de médicos não encontrado, iniciando com lista vazia.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            // Le as linhas do arquivo
            while ((linha = reader.readLine()) != null) {
                // Converte o csv em array
                String[] dados = linha.split(",");
                // Cria e adiciona o plano de saúde na lista
                Medico medico = new Medico(dados[0], dados[1], dados[2], Double.parseDouble(dados[3]));
                medicos.add(medico);
            }
        } catch (IOException e) {
            // Se tiver erro exibe a mensagem
            System.err.println("Erro ao carregar os médicos: " + e.getMessage());
        }
    }

    private static void carregarPacientes(List<Paciente> pacientes, List<PlanoDeSaude> planos) {
        // Cria um arquivo
        File arquivo = new File(PACIENTES_CSV);
        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            // Se não existir avisa ao usuário
            System.out.println("Arquivo de pacientes não encontrado, iniciando com lista vazia.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            // Le as linhas do arquivo
            while ((linha = reader.readLine()) != null) {

                // Converte o csv em array
                String[] dados = linha.split(",");

                // Pega os dados
                String nome = dados[0];
                String cpf = dados[1];
                int idade = Integer.parseInt(dados[2]);
                String tipo = dados[3];

                String detalhe;
                if (dados.length > 4) {
                    detalhe = dados[4];
                } else {
                    detalhe = "";
                }

                // Verifica se o paciente é especial
                if ("ESPECIAL".equals(tipo)) {
                    // Busca o plano
                    PlanoDeSaude plano = buscarPlanoPorNome(detalhe, planos);
                    pacientes.add(new PacienteEspecial(nome, cpf, idade, plano));
                } else {
                    // se não for especial assume que é um paciente comum
                    pacientes.add(new PacienteComum(nome, cpf, idade, detalhe));
                }
            }
        } catch (IOException e) {
            // Se tiver erro exibe a mensagem
            System.err.println("Erro ao carregar os pacientes: " + e.getMessage());
        }
    }

    private static void carregarConsultas(List<Consulta> consultas, List<Paciente> pacientes, List<Medico> medicos) {
        // Cria um arquivo
        File arquivo = new File(CONSULTAS_CSV);
        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            // Se não existir avisa ao usuário
            System.out.println("Arquivo de consultas não encontrado, iniciando com lista vazia.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            // Le as linhas do arquivo
            while ((linha = reader.readLine()) != null) {
                // Converte o csv em array
                String[] dados = linha.split(";", -1);

                // Busca paciente e médico já existentes
                Paciente p = buscarPacientePorCpf(dados[0], pacientes);
                Medico m = buscarMedicoPorCrm(dados[1], medicos);

                // Verifica se os dois são não-nulos
                if (p != null && m != null) {
                    LocalDateTime data = LocalDateTime.parse(dados[2], FORMATADOR_DATA_HORA);

                    // Instancia do objeto
                    Consulta c = new Consulta(p, m, data, "");
                    c.setStatus(dados[3]);
                    c.setDiagnostico(dados[4]);
                    c.setPrescricao(dados[5]);

                    // Adiciona na lista
                    consultas.add(c);
                }
            }
        } catch (Exception e) {
            // Se tiver erro exibe a mensagem
            System.err.println("Erro falha ao processar linha de consulta: " + e.getMessage());
        }
    }

    private static PlanoDeSaude buscarPlanoPorNome(String nome, List<PlanoDeSaude> planos) {
        // Passa pelos objetos da lista
        for (PlanoDeSaude p : planos) {
            // Verifica se o plano que estamos procurando é igual a um da lista
            if (p.getNomePlano().equals(nome)) {
                // Retorna o objeto se encontrar o plano
                return p;
            }
        }
        // Se não encontrar o nome do plano retorna nulo
        return null;
    }

    private static Paciente buscarPacientePorCpf(String cpf, List<Paciente> pacientes) {
        // Passa pelos objetos da lista
        for (Paciente p : pacientes) {
            // Verifica se o cpf que estamos procurando é igual a um da lista
            if (p.getCpf().equals(cpf)) {
                // Retorna o objeto se encontrar o paciente
                return p;
            }
        }
        // Se não encontra o cpf do paciente retorna nulo
        return null;
    }

    private static Medico buscarMedicoPorCrm(String crm, List<Medico> medicos) {
        // Passa pelos objetos da lista
        for (Medico m : medicos) {
            // Verifica se o crm que estamos procurando é igual a um da lista
            if (m.getCrm().equals(crm)) {
                // Retorna o objeto se encontrar o crm
                return m;
            }
        }
        // Se não encontra o crm do médico retorna nulo
        return null;
    }
}
