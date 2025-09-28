package model;

public class PlanoDeSaude {

    // Atributos da classe PlanoDeSaude
    private String nomePlano;
    private double descontoBase;
    private String descricaoPlano;
    private boolean permiteInternacaoEspecial;

    // Construtor vazio
    public PlanoDeSaude() {

    }

    // Construtor com parâmetros
    public PlanoDeSaude(String nomePlano, double descontoBase, String descricaoPlano,
            boolean permiteInternacaoEspecial) {
        this.nomePlano = nomePlano;
        this.descontoBase = descontoBase;
        this.descricaoPlano = descricaoPlano;
        this.permiteInternacaoEspecial = permiteInternacaoEspecial;
    }

    // Método PlanoDeSaude para aplicar o desconto do plano
    public double aplicarDesconto(double custo, Paciente paciente) {
        double desconto = this.descontoBase;

        // Calcular o desconto com base na idade do paciente
        if (paciente.getIdade() >= 60) {
            desconto += 0.10;
        }

        // Limite pro desconto não passar de 100%
        if (desconto > 1.0) {
            desconto = 1.0;
        }

        double valorDesconto = custo * desconto;
        double custoTotal = custo - valorDesconto;

        return custoTotal;
    }

    // Método PlanoDeSaude para saber se o plano é especial
    public boolean podeTerIntenacaoEspecial() {

        return this.podeTerIntenacaoEspecial();

    }

    // Getters e Setters
    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public double getDescontoBase() {
        return descontoBase;
    }

    public void setDescontoBase(double descontoBase) {
        this.descontoBase = descontoBase;
    }

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    public void setDescricaoPlano(String descricaoPlano) {
        this.descricaoPlano = descricaoPlano;
    }

    public boolean isPermiteInternacaoEspecial() {
        return permiteInternacaoEspecial;
    }

    public void setPermiteInternacaoEspecial(boolean permiteInternacaoEspecial) {
        this.permiteInternacaoEspecial = permiteInternacaoEspecial;
    }

}
