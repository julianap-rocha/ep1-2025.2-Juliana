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

    // Getters e Setters
    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

}
