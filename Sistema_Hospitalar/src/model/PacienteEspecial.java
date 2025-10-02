package model;

//PacienteEspecial herda de Paciente para utilizar os atributos em comum
public class PacienteEspecial extends Paciente {

    // Atributos de PlanoDeSaude
    private PlanoDeSaude planoDeSaude; // Associação entre o PacienteEspecial e PlanoDeSaude

    // Construtor vazio
    public PacienteEspecial() {

    }

    // Construtor com parâmetros
    public PacienteEspecial(String nome, String cpf, int idade, PlanoDeSaude planoDeSaude) {
        super(nome, cpf, idade);
        this.planoDeSaude = planoDeSaude;
    }

    // Método para calcular o custo da consulta para pacientes especiais
    @Override
    public double calcularCustoConsulta(double custoBase) {
        // Verifica se o paciente tem plano de saúde diferente de nulo
        if (this.planoDeSaude != null) {
            // Vai aplicar o desconto do plano de saúde
            return this.planoDeSaude.aplicarDesconto(custoBase, this);
        }
        // Se for nulo retorna o custo base normal
        return custoBase;
    }

    // Método para verificar se o paciente possui um plano de saúde
    @Override
    public boolean possuiPlano(String nomePlano) {
        /*
         * Verifica se o paciente tem plano de saúde diferente de nulo e se o nome do
         * plano corresponde
         */
        if (this.planoDeSaude != null && this.planoDeSaude.getNomePlano().equalsIgnoreCase(nomePlano)) {
            return true;
        }
        // Se as condições não forem verdadeiras retorna que não possui plano
        return false;
    }

    // Getters e Setters
    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

}
